package br.ufc.dc.poo.exception;

public class UNCException	extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public UNCException(String usuario) {
		super("Usuario inexistente");
		this.usuario = usuario;
		
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
	

}
