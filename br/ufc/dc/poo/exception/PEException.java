package br.ufc.dc.poo.exception;

public class PEException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PEException(String usuario) {
		super("Perfil já existente: ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}

	
	
	
	
}