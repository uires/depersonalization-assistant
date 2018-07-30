package org.depersonalizationAssistant.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

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
	public ModelAndView pacienteMapping() {
		return new ModelAndView("paciente/cadastropaciente");
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView cadastro(Paciente paciente, Endereco endereco) {
		paciente.setEndereco(endereco);
		paciente.setDataNascimento(Calendar.getInstance());
		dao.cadastraPaciente(paciente);
		return new ModelAndView("redirect:/dashboard");
	}

	@RequestMapping("paciente/login")
	public ModelAndView logarMapping() {
		return new ModelAndView("paciente/login");
	}

	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public ModelAndView logar(Paciente paciente, HttpSession sessionHttpObjectServlet) {
		if (dao.logar(paciente) != null) {
			sessionHttpObjectServlet.setAttribute("usuario.logado", dao.logar(paciente));
			return new ModelAndView("redirect:/dashboard");
		} else {
			return new ModelAndView("paciente/login");
		}
	}
}
