package org.depersonalizationAssistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.depersonalizationAssistant.factory.ConnectionFactory;
import org.depersonalizationAssistant.model.Endereco;
import org.depersonalizationAssistant.model.Paciente;

public class PacienteDAO {

	public void cadastraPaciente(Paciente paciente) {
		String sql = "INSERT INTO paciente (nome, email, sexo, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection conexao = ConnectionFactory.getConnection();

			PreparedStatement sentenca = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			sentenca.setString(1, paciente.getNome());
			sentenca.setString(2, paciente.getEmail());
			sentenca.setString(3, paciente.getSexo());
			sentenca.setString(4, paciente.getCpf());
			sentenca.setString(5, paciente.getTelefone());
			sentenca.execute();
			this.cadastrarEndereco(paciente.getEndereco(), (long) sentenca.getGeneratedKeys().getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void cadastrarEndereco(Endereco endereco, Long idPaciente) {
		String sql = "INSERT INTO endereco (id_paciente, rua, cep, estado, complemento, cidade) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idPaciente);
			statement.setString(2, endereco.getRua());
			statement.setString(3, endereco.getCep());
			statement.setString(4, endereco.getEstado());
			statement.setString(5, endereco.getComplemento());
			statement.setString(6, endereco.getCidade());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
