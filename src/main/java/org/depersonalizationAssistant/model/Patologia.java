package org.depersonalizationAssistant.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Patologia {
	private Long id;
	private NomePatologia nomePatologia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataInicio;

	public Patologia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NomePatologia getNomePatologia() {
		return nomePatologia;
	}

	public void setNomePatologia(NomePatologia nomePatologia) {
		this.nomePatologia = nomePatologia;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

}
