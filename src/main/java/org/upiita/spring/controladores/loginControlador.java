package org.upiita.spring.controladores;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.upiita.spring.formas.FormaSession;

@Controller
public class loginControlador {
	
	@Autowired
	private FormaSession formaSession;
	
	@RequestMapping(value="/login")
	public String login(Boolean errorLogin, Model modelo, HttpSession session){

		System.out.println("LOGIN ENTRANDO");
		modelo.addAttribute("errorLogin",errorLogin);
		formaSession.setItemsComprados(100);
		
		session.setAttribute("variable", 10);
		
		return "login";
	}
	
	@RequestMapping(value="/error-403")
	public String error403(Authentication autenticacion, Model modelo){
		System.out.println("NOMBRE: " +autenticacion.getName());
		System.out.println("PASSWORD: "+autenticacion.getCredentials());
		System.out.println("ROLES: "+ autenticacion.getAuthorities());
		
		modelo.addAttribute("email", autenticacion.getName());
		
		return "error-403";
	}
	
}
