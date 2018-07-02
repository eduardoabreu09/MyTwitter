package br.ufc.dc.poo.exception;

public class UJCException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UJCException(String usuario) {
		super("Conta já existente");
		this.usuario = usuario;
	}
	public String getUsuario() {
		return this.usuario;
		
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
