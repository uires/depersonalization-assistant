package org.depersonalizationAssistant.model;

public class Relatorio {
	private Long id;
	private Long idPaciente;
	private Patologia patologia;
	private String descricao;

	public Relatorio() {

	}

	public Relatorio(Long id, Long idPaciente, Patologia patologia, String descricao) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.patologia = patologia;
		this.descricao = descricao;
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

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
