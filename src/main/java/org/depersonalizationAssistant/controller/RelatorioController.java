package org.depersonalizationAssistant.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.depersonalizationAssistant.model.Paciente;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {

	@RequestMapping("relatorio/cadastrar")
	public ModelAndView cadastrarMap() {
		return new ModelAndView("relatorio/cadastrarelatorio");
	}

	@RequestMapping("cadastrarRelatorio")
	public ModelAndView cadastrarRelatorio(Relatorio relatorio, Patologia patologia, HttpSession sessao) {
		Paciente paciente = (Paciente) sessao.getAttribute("usuario.logado");
		patologia.setDataInicio(Calendar.getInstance());
		relatorio.setPatologia(patologia);
		relatorio.setIdPaciente((long) paciente.getId());
		return new ModelAndView("dashboard");
	}

}
