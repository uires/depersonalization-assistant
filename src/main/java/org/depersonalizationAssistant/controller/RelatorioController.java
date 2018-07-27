package org.depersonalizationAssistant.controller;

import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.depersonalizationAssistant.model.SessionModelReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {
	@Autowired
	private RelatorioDAO repository;

	@RequestMapping("relatorio/cadastrar")
	public ModelAndView cadastrarMap() {
		return new ModelAndView("relatorio/cadastrarelatorio");
	}

	@RequestMapping(value = "cadastrarRelatorio", method = RequestMethod.POST)
	public ModelAndView cadastrarRelatorio(Relatorio relatorio, Patologia patologia, HttpSession sessao) {
		patologia.setDataInicio(Calendar.getInstance());
		relatorio.setPatologia(patologia);
		relatorio.setIdPaciente(SessionModelReturn.getPaciente(sessao).getId());
		repository.cadastraRelatorio(relatorio, relatorio.getIdPaciente());
		return new ModelAndView("/");
	}

	public ModelAndView relatoriosReturn(HttpSession session) {
		LinkedList<Relatorio> selectAllRelatoriosPacienteSession = repository
				.selectAllRelatoriosPacienteSession(SessionModelReturn.getPaciente(session).getId());
		if (!(selectAllRelatoriosPacienteSession == null)) {
			return new ModelAndView().addObject("relatos", selectAllRelatoriosPacienteSession);
		} else {
			return new ModelAndView().addObject("notice", "Você não tem nenhum cadastrado!");
		}

	}

	public ModelAndView relatosPublicos() {
		return null;
	}

}
