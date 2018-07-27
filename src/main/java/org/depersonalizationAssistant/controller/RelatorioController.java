package org.depersonalizationAssistant.controller;

import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {

	@RequestMapping("relatorio/cadastrar")
	public ModelAndView cadastrarMap() {
		return new ModelAndView("relatorio/cadastrarelatorio");
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarRelatorio(Relatorio relatorio, Patologia patologia) {
		relatorio.setPatologia(patologia);
		System.out.println(relatorio.getDescricao());
		System.out.println(patologia.getDataInicio());
		return new ModelAndView("redirect:/dashboard");
	}

}
