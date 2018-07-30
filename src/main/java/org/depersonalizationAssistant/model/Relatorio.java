package org.depersonalizationAssistant.model;

import java.util.ArrayList;

public class Relatorio {
	private Long id;
	private Long idPaciente;
	private Long idPatologia;
	private String titulo;
	private Patologia patologia;
	private boolean publico;
	private String descricao;
	private ArrayList<Comentario> comentarios;

	public Relatorio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Long getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(Long idPatologia) {
		this.idPatologia = idPatologia;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
