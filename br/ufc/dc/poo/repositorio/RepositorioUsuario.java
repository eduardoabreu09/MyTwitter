package br.ufc.dc.poo.repositorio;

import br.ufc.dc.poo.exception.UJCException;
import br.ufc.dc.poo.exception.UNCException;
import br.ufc.dc.poo.usuario.*;


import java.util.Vector;





public class RepositorioUsuario implements IRepositorioUsuario {
	private Vector<Perfil> usuarios;
	
	public RepositorioUsuario() {
		this.usuarios = new Vector<Perfil>();
		
		
	}
	

	
	public void cadastrar(Perfil usuario) throws UJCException {
		
		
		try {
			if (this.buscar(usuario.getUsuario()) == null) {
				this.usuarios.add(usuario);

				
			} else {
				throw new UJCException(usuario.getUsuario());
			}
		} catch (UJCException e) {
			e.printStackTrace();
		} 

	}
		
		
	

	
	public Perfil buscar(String usuario) {
		for (Perfil u : usuarios) {
			if (u.getUsuario().equals(usuario)) {
				return u;
			}
		}
		return null;
		
	}

	
	public void atualizar(Perfil usuario) throws UNCException {
	
		
		Perfil p = this.buscar(usuario.getUsuario());
		if (p != null) {
			int aux = this.usuarios.indexOf(p);
			this.usuarios.add(aux,usuario);
			

		} else {
			throw new UNCException(usuario.getUsuario());
		}
	}
	
	
		
}


