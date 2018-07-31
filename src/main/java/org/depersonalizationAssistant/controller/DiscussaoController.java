package org.depersonalizationAssistant.controller;

import javax.servlet.http.HttpSession;

import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.model.Comentario;
import org.depersonalizationAssistant.model.Relatorio;
import org.depersonalizationAssistant.model.SessionModelReturn;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView enviarComentario(Comentario comentario, HttpSession sessao){
		comentario.setIdAutor(SessionModelReturn.getPaciente(sessao).getId());
		comentario.setNomeAutor(SessionModelReturn.getPaciente(sessao).getNome());
		repository.adicionarComentario(comentario.getIdRelatorio(), comentario);
		return this.relatorio(comentario.getIdRelatorio());
	}
}
