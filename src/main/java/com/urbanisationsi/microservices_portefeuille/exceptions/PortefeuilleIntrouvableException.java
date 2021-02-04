package com.urbanisationsi.microservices_portefeuille.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PortefeuilleIntrouvableException extends RuntimeException 
{
	private static final long serialVersionUID = -2061219890734897500L;

	public PortefeuilleIntrouvableException(String msg)
	{
		super(msg);
	}
}
