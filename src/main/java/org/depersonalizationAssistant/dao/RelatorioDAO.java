package org.depersonalizationAssistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.depersonalizationAssistant.factory.ConnectionFactory;
import org.depersonalizationAssistant.model.NomePatologia;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.springframework.stereotype.Repository;

@Repository
public class RelatorioDAO {

	public void cadastraRelatorio(Relatorio relatorio, Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO relatorio ( " + "id_paciente, id_patologia, descricao) " + "VALUES (?, ?, ?)");
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql.toString());
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, this.insertPatologia(conexao, relatorio.getPatologia()));
			preparedStatement.setString(3, relatorio.getDescricao());
			preparedStatement.execute();
			preparedStatement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private long insertPatologia(Connection conexao, Patologia patologia) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO patologia ( ");
		sql.append("nome_patologia, data_inicio) " + "VALUES (?, ?)");
		try {
			PreparedStatement prepareStatement = conexao.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			prepareStatement.setString(1, patologia.getNomePatologia().toString());
			java.sql.Date dateConvert = new java.sql.Date(patologia.getDataInicio().getTimeInMillis());
			prepareStatement.setDate(2, dateConvert);
			prepareStatement.executeUpdate();
			ResultSet executeQuery = prepareStatement.getGeneratedKeys();
			if (executeQuery.next()) {
				long long1 = executeQuery.getLong(1);
				return long1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public LinkedList<Relatorio> selectAllRelatoriosPacienteSession(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("ID NÃO PODE SER NULO!");
		}
		LinkedList<Relatorio> relatoriosList = new LinkedList<>();
		String sql = "SELECT * FROM relatorio WHERE id_paciente = ?";
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeQuery();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				Relatorio relato = new Relatorio();
				relato.setId(resultSet.getLong("id"));
				relato.setIdPaciente(resultSet.getLong("id_paciente"));
				relato.setDescricao(resultSet.getString("descricao"));
				relato.setIdPatologia(resultSet.getLong("id_patologia"));
				relato.setPatologia(this.selectPatologiaById(conexao, relato.getIdPatologia()));
				relatoriosList.add(relato);
			}
			statement.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatoriosList;
	}

	private Patologia selectPatologiaById(Connection conexao, Long idPatologia) {
		String sql = "SELECT * FROM patologia WHERE id = ?";
		try {
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setLong(1, idPatologia);
			ResultSet executeQuery = preparedStatement.executeQuery();
			if (executeQuery.next()) {
				Patologia patologia = new Patologia();
				Calendar date = new GregorianCalendar();
				date.setTime(executeQuery.getDate("data_inicio"));
				patologia.setDataInicio(date);
				patologia.setNomePatologia(NomePatologia.valueOf(executeQuery.getString("nome_patologia")));
				return patologia;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public LinkedList<Relatorio> selectAllRelatoriosPublic() {
		String sql = "SELECT * FROM relatorio WHERE publica = ?";
		LinkedList<Relatorio> relatorios = new LinkedList<>();
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setBoolean(1, true);
			ResultSet executeQuery = statement.executeQuery();
			while (executeQuery.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setDescricao(executeQuery.getString("descricao"));
				relatorio.setId(executeQuery.getLong("id"));
				relatorio.setIdPaciente(executeQuery.getLong("id_paciente"));
				relatorio.setIdPatologia(executeQuery.getLong("id_patologia"));
				relatorio.setPatologia(this.selectPatologiaById(conexao, executeQuery.getLong("id_patologia")));
				relatorios.add(relatorio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatorios;
	}

	public LinkedList<Relatorio> selectRelatorioByDesc(String criterioDeBusca) {
		String sql = "SELECT * FROM relatorio descricao LIKE ?";
		LinkedList<Relatorio> relatorios = new LinkedList<>();
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, "%" + criterioDeBusca + "%");
			statement.executeQuery();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setId(resultSet.getLong("id"));
				relatorio.setDescricao(resultSet.getString("descricao"));
				relatorio.setPatologia(this.selectPatologiaById(conexao, resultSet.getLong("id_patologia")));
				relatorio.setPublico(resultSet.getBoolean("publico"));
				relatorios.add(relatorio);
			}
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatorios;
	}

}
