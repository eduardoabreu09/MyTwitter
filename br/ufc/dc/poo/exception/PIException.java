package br.ufc.dc.poo.exception;

public class PIException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PIException(String usuario) {
		super("Perfil inexistente : ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}
