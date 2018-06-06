package br.ufc.dc.poo.usuario;
import java.util.Vector;
import br.ufc.dc.poo.tweet.Tweet;

public abstract class Perfil{

	private String usuario;
	private Vector<Perfil> seguidores;
	private Vector<Perfil> seguidos;
	private boolean ativo;
	private Vector<Tweet> timeline;

	public Perfil(String usuario){
		this.usuario = usuario;
		this.seguidores = new Vector<Perfil>();
		this.seguidos = new Vector<Perfil>();
		this.ativo = true;
		this.timeline = new Vector<Tweet>();

	}

	public void addSeguido(Perfil usuario){
		seguidos.add(usuario);


	}

	public void addSeguidor(Perfil usuario){
		seguidores.add(usuario);



	}

	public void addTweet(Tweet tweet){
		timeline.add(tweet);

	}

	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

	public String getUsuario(){
		return this.usuario;

	}

	public Vector<Perfil> getSeguidos(){
		return seguidos;

	}

	public Vector<Perfil> getSeguidores(){
		return seguidores;

	}

	public Vector<Tweet> getTimeline(){
		return timeline;

	}

	public void setAtivo(boolean valor){
		this.ativo=valor;

	}

	public boolean isAtivo(){
		return ativo;

	}


}