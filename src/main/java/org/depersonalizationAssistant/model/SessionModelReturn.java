package org.depersonalizationAssistant.model;

import javax.servlet.http.HttpSession;

public class SessionModelReturn {

	public static Paciente getPaciente(HttpSession session){
		return (Paciente) session.getAttribute("usuario.logado");
	}
}
