package com.example.proyectofinal.excepciones;

public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(Long id) {
		    super("Could not found " + id);
		  }
}
