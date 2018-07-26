package org.depersonalizationAssistant.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.depersonalizationAssistant.factory.ConnectionFactory;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;

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
		sql.append("nome_patologia, data_inicio) " + "VALUES (?, ?, ?)");
		try {
			PreparedStatement prepareStatement = conexao.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			prepareStatement.setString(1, patologia.getNomePatologia().toString());
			java.sql.Date dateConvert = new java.sql.Date(patologia.getDataInicio().getTimeInMillis());
			prepareStatement.setDate(2, dateConvert);
			prepareStatement.executeQuery();
			ResultSet executeQuery = prepareStatement.getGeneratedKeys();
			if (executeQuery.next()) {
				long long1 = executeQuery.getLong(1);
				return long1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
