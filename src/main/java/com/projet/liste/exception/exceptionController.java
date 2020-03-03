package com.projet.liste.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class exceptionController {
	private Log logger = LogFactory.getLog(exceptionController.class);
	
	@ExceptionHandler(value =Exception.class )
	public String handleError(HttpServletRequest req, Exception exception) {
		logger.error("Request: "+ req.getRequestURL()+" raised "+exception);
		return "error";
		
	}
}
