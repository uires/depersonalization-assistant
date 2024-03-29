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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {

	@Autowired
	private RelatorioDAO repository;

	@RequestMapping("relatorio/cadastrar")
	public ModelAndView cadastrarMap() {
		return new ModelAndView("relatorio/cadastra-relatorio");
	}

	@RequestMapping(value = "cadastrarRelatorio", method = RequestMethod.POST)
	public ModelAndView cadastrarRelatorio(Relatorio relatorio, Patologia patologia, HttpSession sessao) {

		patologia.setDataInicio(Calendar.getInstance());
		relatorio.setPatologia(patologia);
		relatorio.setIdPaciente(SessionModelReturn.getPaciente(sessao).getId());

		repository.cadastraRelatorio(relatorio, relatorio.getIdPaciente());
		return new ModelAndView("/");
	}

	@RequestMapping(value = "relatorio/meus-relatorios", method = RequestMethod.GET)
	public ModelAndView relatoriosReturn(HttpSession session) {
		LinkedList<Relatorio> selectAllRelatoriosPacienteSession = repository
				.selectAllRelatoriosPacienteSession(SessionModelReturn.getPaciente(session).getId());

		if (selectAllRelatoriosPacienteSession.size() >= 1) {
			return new ModelAndView("relatorio/meus-relatorios").addObject("relatos",
					selectAllRelatoriosPacienteSession);
		}

		return new ModelAndView("relatorio/meus-relatorios").addObject("notice",
				"Você não tem nenhum relatório cadastrado.");
	}

	@RequestMapping(value = "relatorio/relatorios-publicos", method = RequestMethod.GET)
	public ModelAndView relatosPublicos() {
		LinkedList<Relatorio> relatorios = this.repository.selectAllRelatoriosPublic();
		System.out.println(relatorios.get(0));
		return new ModelAndView("relatorio/relatorio-publico").addObject("relatoriosPublicos", relatorios);
	}

	@RequestMapping(value = "buscar", method = RequestMethod.POST)
	public ModelAndView buscar(@RequestParam("criterio") String criterioDeBusca) {
		if (repository.selectRelatorioByDesc(criterioDeBusca).size() > 0) {
			return this.relatosPublicos().addObject("relatoriosPublicos",
					repository.selectRelatorioByDesc(criterioDeBusca));
		}

		return this.relatosPublicos().addObject("notice", "Não teve resultado essa buscar.");
	}
}
