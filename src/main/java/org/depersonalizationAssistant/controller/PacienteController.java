package org.depersonalizationAssistant.controller;

import org.depersonalizationAssistant.model.Endereco;
import org.depersonalizationAssistant.model.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {

	@RequestMapping("paciente/cadastro")
	public ModelAndView form() {
		return new ModelAndView("paciente/cadastropaciente");
	}

	@RequestMapping("cadastrar")
	public ModelAndView cadastro(Paciente paciente, Endereco endereco) {
		paciente.setEndereco(endereco);
		System.out.println(paciente);
		return new ModelAndView("/");
	}
}
