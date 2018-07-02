package br.ufc.dc.poo.exception;

public class MFPException extends Exception{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Mensagem possui menos que 1 ou mais que 140 caracteres");
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
