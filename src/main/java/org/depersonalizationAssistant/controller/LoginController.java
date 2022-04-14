package org.depersonalizationAssistant.controller;

import javax.servlet.http.HttpSession;

import org.depersonalizationAssistant.dao.PacienteDAO;
import org.depersonalizationAssistant.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private PacienteDAO dao;

	@RequestMapping("/login")
	public ModelAndView logarMapping() {
		return new ModelAndView("auth/login");
	}

	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public ModelAndView logar(Paciente paciente, HttpSession sessionHttpObjectServlet) {

		if (dao.logar(paciente) != null) {
			sessionHttpObjectServlet.setAttribute("usuario.logado", dao.logar(paciente));
			return new ModelAndView("redirect:/dashboard");
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public ModelAndView sair(Paciente paciente, HttpSession sessionHttpObjectServlet) {
		sessionHttpObjectServlet.removeAttribute("usuario.logado");

		return new ModelAndView("redirect:/login");
	}
}
