package org.depersonalizationAssistant.model;

import java.util.Calendar;

public class Paciente {

	private int id;
	private String nome;
	private String email;
	private String sexo;
	private String cpf;
	private String telefone;
	private Calendar dataNascimento;
	private Endereco endereco;
	private String senha;

	public Paciente() {
	}

	public Paciente(int id, String nome, String email, String sexo, String cpf, String telefone, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "[\nNome" + this.nome + "\nEmail:" + this.getEmail() + "\n" + this.getTelefone() + "\nEndereço:"
				+ this.getEndereco().getEstado() + "\nRua:" + this.getEndereco().getRua() + "\nCidade:"
				+ this.getEndereco().getCidade();
	}

}
