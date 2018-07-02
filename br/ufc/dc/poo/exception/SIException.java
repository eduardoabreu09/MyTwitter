package br.ufc.dc.poo.exception;

public class SIException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SIException() {
		super("Perfil do seguidor é igual ao do seguido. ");
		
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}