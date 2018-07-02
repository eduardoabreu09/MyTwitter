package br.ufc.dc.poo.repositorio;



import br.ufc.dc.poo.exception.UJCException;
import br.ufc.dc.poo.exception.UNCException;
import br.ufc.dc.poo.usuario.Perfil;


public interface IRepositorioUsuario {
	public void cadastrar(Perfil usuario) throws UJCException;
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario) throws UNCException;
	

}
