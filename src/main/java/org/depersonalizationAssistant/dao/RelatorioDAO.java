package org.depersonalizationAssistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.depersonalizationAssistant.factory.ConnectionFactory;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.springframework.stereotype.Repository;

@Repository
public class RelatorioDAO {

	public void cadastraRelatorio(Relatorio relatorio, Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO relatorio ( " 
					+ "id_paciente, id_patologia, descricao) " 
					+ "VALUES (?, ?, ?)");
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
		sql.append("nome_patologia, data_inicio) " 
					+ "VALUES (?, ?)");
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
		LinkedList<Relatorio> relatorios = null;
		String sql = "SELECT * FROM relatorio WHERE id_paciente = ?";
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Relatorio relato = new Relatorio();
				relato.setId(resultSet.getLong("id"));
				relato.setIdPaciente(resultSet.getLong("id_paciente"));
				relato.setDescricao(resultSet.getString("descricao"));
				relato.setPatologia(this.selectPatologiaById(conexao, ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatorios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
