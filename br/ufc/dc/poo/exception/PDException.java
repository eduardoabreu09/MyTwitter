package br.ufc.dc.poo.exception;

public class PDException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PDException(String usuario) {
		super("Perfil inativo : ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}
