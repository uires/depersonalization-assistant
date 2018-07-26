package org.depersonalizationAssistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView dashboardHome() {
		return new ModelAndView("index");
	}

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		return new ModelAndView("index");
	}

	@RequestMapping("/sobre")
	public ModelAndView sobre() {
		return new ModelAndView("sobre");
	}

}
