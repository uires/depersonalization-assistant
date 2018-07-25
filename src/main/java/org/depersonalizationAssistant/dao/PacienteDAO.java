package org.depersonalizationAssistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import org.depersonalizationAssistant.factory.ConnectionFactory;
import org.depersonalizationAssistant.model.Endereco;
import org.depersonalizationAssistant.model.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteDAO {

	public void cadastraPaciente(Paciente paciente) {
		String sql = "INSERT INTO paciente (nome, email, sexo, cpf, telefone, data_nascimento, senha) VALUES (?, ?, ?, ?, ?, ?, MD5(?))";
		try {
			Connection conexao = ConnectionFactory.getConnection();

			PreparedStatement sentenca = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			sentenca.setString(1, paciente.getNome());
			sentenca.setString(2, paciente.getEmail());
			sentenca.setString(3, paciente.getSexo());
			sentenca.setString(4, paciente.getCpf());
			sentenca.setString(5, paciente.getTelefone());
			java.sql.Date dataSql = new java.sql.Date(paciente.getDataNascimento().getTimeInMillis());
			sentenca.setDate(6, dataSql);
			sentenca.setString(7, paciente.getSenha());
			sentenca.executeUpdate();
			ResultSet generatedKeys = sentenca.getGeneratedKeys();
			if (generatedKeys.next()) {
				long long1 = generatedKeys.getLong(1);
				this.cadastrarEndereco(paciente.getEndereco(), long1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void cadastrarEndereco(Endereco endereco, Long idPaciente) throws SQLException {
		String sql = "INSERT INTO endereco (id_paciente, rua, cep, estado, complemento, cidade) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setLong(1, idPaciente);
		statement.setString(2, endereco.getRua());
		statement.setString(3, endereco.getCep());
		statement.setString(4, endereco.getEstado());
		statement.setString(5, endereco.getComplemento());
		statement.setString(6, endereco.getCidade());
		statement.execute();
	}

	public Paciente selectPacienteAndEnderecoById(Long id) {
		if (id == null) {
			throw new RuntimeErrorException(null, "id está nulo");
		}
		Paciente paciente = null;
		String sql = "SELECT nome, email, sexo, cpf, telefone FROM paciente WHERE id = ?";
		try {
			Connection conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet executeQuery = statement.executeQuery();
			if (executeQuery.next()) {
				paciente = new Paciente();
				paciente.setNome(executeQuery.getString("nome"));
				paciente.setEmail(executeQuery.getString("email"));
				paciente.setSexo(executeQuery.getString("sexo"));
				paciente.setCpf(executeQuery.getString("cpf"));
				paciente.setTelefone(executeQuery.getString("telefone"));
				paciente.setEndereco(this.selectEndereco(paciente));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	private Endereco selectEndereco(Paciente paciente) throws SQLException {
		Endereco endereco = new Endereco();
		String sql = "SELECT * FROM endereco WHERE id_paciente = ?";
		Connection conexao = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = conexao.prepareStatement(sql);
		preparedStatement.setLong(1, paciente.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			endereco = new Endereco();
			endereco.setId((long) resultSet.getInt("id"));
			endereco.setIdPaciente((long) paciente.getId());
			endereco.setCep(resultSet.getString("cep"));
			endereco.setCidade(resultSet.getString("cidade"));
			endereco.setComplemento(resultSet.getString("complemento"));
			endereco.setEstado(resultSet.getString("resultSet"));
			endereco.setRua(resultSet.getString("rua"));
		}
		return endereco;
	}

	public Paciente logar(Paciente paciente) {
		String sql = "SELECT * FROM paciente WHERE email = ? AND senha = MD5(?)";
		Connection conexao;
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, paciente.getEmail());
			statement.setString(2, paciente.getSenha());
			ResultSet executeQuery = statement.executeQuery();

			if (executeQuery.next()) {
				return this.selectPacienteAndEnderecoById(executeQuery.getLong("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
