package org.depersonalizationAssistant.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.depersonalizationAssistant.model.SessionModelReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {
	@Autowired
	private RelatorioDAO repository;
	
	@RequestMapping("relatorio/cadastrar")
	public ModelAndView cadastrarMap() {
		return new ModelAndView("relatorio/cadastrarelatorio");
	}

	@RequestMapping("cadastrarRelatorio")
	public ModelAndView cadastrarRelatorio(Relatorio relatorio, Patologia patologia, HttpSession sessao) {
		patologia.setDataInicio(Calendar.getInstance());
		relatorio.setPatologia(patologia);
		relatorio.setIdPaciente((long) SessionModelReturn.getPaciente(sessao).getId());
		repository.cadastraRelatorio(relatorio, relatorio.getIdPaciente());
		return new ModelAndView("/");
	}

}
