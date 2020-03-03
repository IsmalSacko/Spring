package com.projet.web;

import org.springframework.stereotype.Service;

@Service
public class ValidPassword {
	
	public boolean estValide(String prenom, String password) {
		
		
		if(prenom.equals("Alex") && password.equals("admin")) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
