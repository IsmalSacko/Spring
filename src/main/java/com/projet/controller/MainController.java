package com.projet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projet.web.ValidPassword;

@Controller
@SessionAttributes("prenom")
public class MainController {
	
	@Autowired
	ValidPassword validPassword;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String pageAccueil(Model model) {
		model.addAttribute("prenom", getLoggedInUserName());
		return "bienvenue";
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	/*
	 * @RequestMapping(value="/", method = RequestMethod.POST) public String
	 * PostMethod(@RequestParam String prenom, @RequestParam String password, Model
	 * model) {
	 * 
	 * if(!validPassword.estValide(prenom, password)) {
	 * 
	 * model.addAttribute("error_login", "Le prenom ou mot de passe est invalide");
	 * return "accueil";
	 * 
	 * }
	 * 
	 * model.addAttribute("prenom", prenom); model.addAttribute("password",
	 * password);
	 * 
	 * return "bienvenue"; }
	 */
}
