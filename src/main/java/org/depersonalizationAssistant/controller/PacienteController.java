package org.depersonalizationAssistant.controller;

import org.depersonalizationAssistant.model.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {

	@RequestMapping("paciente/cadastro")
	public ModelAndView form() {
		return new ModelAndView("paciente/cadastropaciente");
	}

	@RequestMapping(value = "cadastrarPaciente", method = RequestMethod.POST)
	public ModelAndView cadastro(Paciente paciente) {
		return new ModelAndView();
	}
}
