package org.depersonalizationAssistant.model;

public class Endereco {
	private Long id;
	private Long idPaciente;
	private String rua;
	private String cep;
	private String estado;
	private String complemento;
	private String cidade;

	public Endereco() {
	}

	public Endereco(Long id, Long idPaciente, String rua, String cep, String estado, String complemento,
			String cidade) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.rua = rua;
		this.cep = cep;
		this.estado = estado;
		this.complemento = complemento;
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
