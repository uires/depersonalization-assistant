package org.depersonalizationAssistant.model;

import java.util.Calendar;

public class Patologia {
	private Long id;
	private Long idPaciente;
	private NomePatologia nomePatologia;
	private Calendar dataInicio;
	private Relatorio relatorioPatologia;

	public Patologia() {
	}

	public Patologia(Long id, Long idPaciente, NomePatologia nomePatologia, Calendar dataInicio,
			Relatorio relatorioPatologia) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.nomePatologia = nomePatologia;
		this.dataInicio = dataInicio;
		this.relatorioPatologia = relatorioPatologia;
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

	public Relatorio getRelatorioPatologia() {
		return relatorioPatologia;
	}

	public void setRelatorioPatologia(Relatorio relatorioPatologia) {
		this.relatorioPatologia = relatorioPatologia;
	}

}
