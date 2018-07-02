package br.ufc.dc.poo.mytwitter;

import java.io.IOException;
import java.util.Vector;

import br.ufc.dc.poo.exception.MFPException;
import br.ufc.dc.poo.exception.PDException;
import br.ufc.dc.poo.exception.PEException;
import br.ufc.dc.poo.exception.PIException;
import br.ufc.dc.poo.exception.SIException;
import br.ufc.dc.poo.exception.UJCException;
import br.ufc.dc.poo.exception.UNCException;
import br.ufc.dc.poo.usuario.Perfil;
import br.ufc.dc.poo.tweet.Tweet;

public interface ITwitter {
	public void criarPerfil(Perfil usuario) throws UJCException, PEException;
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException;
	public void tweetar(String usuario,String mensagem) throws PIException, MFPException;
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException, IOException;
	public void seguir(String seguidor,String seguido) throws PIException, PDException, SIException;
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	public Vector<Perfil> seguidores(String  usuario) throws PIException, PDException;
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;

}
