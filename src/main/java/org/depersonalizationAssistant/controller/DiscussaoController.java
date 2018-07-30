package org.depersonalizationAssistant.controller;

import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.model.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiscussaoController {
	@Autowired
	private RelatorioDAO repository;
	
	@RequestMapping(value = "relatorio/discusaorelatorio", method = RequestMethod.GET)
	public ModelAndView relatorio(Long id) {
		Relatorio selectRelatorioById = repository.selectRelatorioById(id);
		return new ModelAndView("relatorio/discusaorelatorio").addObject("relato", selectRelatorioById);
	}
}
