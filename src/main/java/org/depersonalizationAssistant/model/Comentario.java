package org.depersonalizationAssistant.model;

import java.util.Calendar;

public class Comentario {
	private Long id;
	private Long id_relatorio;
	private String titulo;
	private String nomeAutor;
	private Calendar dataPostagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_relatorio() {
		return id_relatorio;
	}

	public void setId_relatorio(Long id_relatorio) {
		this.id_relatorio = id_relatorio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Calendar getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Calendar dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

}
