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
import br.ufc.dc.poo.repositorio.IRepositorioUsuario;
import br.ufc.dc.poo.tweet.Tweet;
import br.ufc.dc.poo.usuario.Perfil;

public class MyTwitter implements ITwitter {
	
	IRepositorioUsuario repositorio;
	Vector<Tweet> tweets;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		
		this.repositorio = repositorio;
		this.tweets = new Vector<Tweet>();
		

	}
	
	@Override
	public void criarPerfil(Perfil usuario) throws UJCException, PEException {
		
		
		if (repositorio.buscar(usuario.getUsuario()) == null) {
			repositorio.cadastrar(usuario);
			

		} else {
			throw new PEException(usuario.getUsuario());
		}
		
	}

	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException {
		
		try {
			Perfil p = repositorio.buscar(usuario);
			if (p != null && p.isAtivo() == true) {
				p.setAtivo(false);
				repositorio.atualizar(p);
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}

		
	}

	@Override
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException {
		
		Tweet t = new Tweet(usuario,mensagem);
		Perfil p = repositorio.buscar(usuario);
		
		
		try{
			if (p != null && p.isAtivo() == true) {
			
			if (mensagem.length() <= 140 && mensagem.length() >=1) {
				
				p.addTweet(t);
				
				this.tweets.add(t);
				
				for (Perfil pe : p.getSeguidores()) {
					if (pe.isAtivo() == true) {
						pe.addTweet(t);
					}
				}
			} 
				else {
					throw new MFPException();
				}
		} else {
			throw new PIException(usuario);
			}
		}
		catch (MFPException e){
			e.printStackTrace();
		}
		catch (PIException ee){
			ee.printStackTrace();
		}
		
	}

	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		
		Perfil p = repositorio.buscar(usuario);
		Vector<Tweet> tws = new Vector<Tweet>();
		
			if (p != null && p.isAtivo() == true) {
			for (Tweet tt : tweets) {
				if (tt.getUsuario().equals(usuario)) {
					tws.add(tt);
				}

				for (Perfil pp : seguidos(usuario)) {
					if (pp.getUsuario().equals(tt.getUsuario())) {
						tws.add(tt);
					}
				}
			}
		}
			if (p == null) {
			throw new PIException(usuario);
		}
			if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}

			return tws;

	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException, IOException {
		Perfil p = repositorio.buscar(usuario);
		
		Vector<Tweet> tws = new Vector<Tweet>();
		try {
			if (p != null && p.isAtivo() == true) {
				for (Tweet tt : tweets) {
					if (tt.getUsuario().equals(usuario)) {
						tws.add(tt);
						
					}

				}
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}

		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return tws;
	}

	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		Perfil p = repositorio.buscar(seguidor);
		Perfil pp = repositorio.buscar(seguido);
	
	
		try {
			if (seguido == seguidor) {
				throw new SIException();
			}

			if (p == null || pp == null) {
				throw new PIException(seguido);
			}
			if (p != null && p.isAtivo() == false || pp != null && p.isAtivo() == false) {
				throw new PDException(seguido);
			}
			if (p != null && p.isAtivo() == true && pp != null && pp.isAtivo() == true) {
				
				pp.addSeguidor(p);
				p.addSeguido(pp);
			}
			
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		} catch (SIException e) {
			e.printStackTrace();
		}
	}
		
	

	@Override
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		int inativos = 0;
		Vector<Perfil> seg = new Vector<Perfil>();
		seg=p.getSeguidores();
		
		try {
			if (p != null && p.isAtivo() == true) {
				for (Perfil pp : seg) {
					if (pp.isAtivo() == false) {
						inativos++;
					}
				}
				return seg.size() - inativos;
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return 0;
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vp = new Vector<Perfil>();
		Vector<Perfil> vst = new Vector<Perfil>();
		vst = p.getSeguidores();
		if (p != null && p.isAtivo() == true) {
			for (Perfil pp : vst) {
				if (pp.isAtivo() == true) {
					vp.add(pp);
				}
			}
		}

		if (p == null) {
			throw new PIException(usuario);
		}
		if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}
		
		return vp;
		
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vst = new Vector<Perfil>();
		Vector<Perfil> vp = new Vector<Perfil>();
		vst = p.getSeguidos();
		if (p != null && p.isAtivo() == true) {
			for (Perfil pp : vst) {
				if (pp.isAtivo() == true) {
					vp.add(pp);
				}
			}
		}
		if (p == null) {
			throw new PIException(usuario);
		} else if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}
		
		return vp;
	}
}
	


