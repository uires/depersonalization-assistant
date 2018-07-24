package org.depersonalizationAssistant.controller;

import org.depersonalizationAssistant.dao.PacienteDAO;
import org.depersonalizationAssistant.model.Endereco;
import org.depersonalizationAssistant.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {
	@Autowired
	private PacienteDAO dao;

	@RequestMapping("paciente/cadastro")
	public ModelAndView form() {
		return new ModelAndView("paciente/cadastropaciente");
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastro(Paciente paciente, Endereco endereco) {
		paciente.setEndereco(endereco);
		dao.cadastraPaciente(paciente);
		return new ModelAndView("/");
	}
}
