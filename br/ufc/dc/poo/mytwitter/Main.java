package br.ufc.dc.poo.mytwitter;


import java.io.IOException;
import br.ufc.dc.poo.exception.MFPException;
import br.ufc.dc.poo.exception.PDException;
import br.ufc.dc.poo.exception.PEException;
import br.ufc.dc.poo.exception.PIException;
import br.ufc.dc.poo.exception.SIException;
import br.ufc.dc.poo.exception.UJCException;
import br.ufc.dc.poo.exception.UNCException;
import br.ufc.dc.poo.repositorio.RepositorioUsuario;
import br.ufc.dc.poo.usuario.*;
import br.ufc.dc.poo.tweet.Tweet;


public class Main {
	public static void main(String[] args) throws UJCException, UNCException, PEException, PIException, PDException,
	MFPException, SIException, IOException {




RepositorioUsuario rp = new RepositorioUsuario();
MyTwitter my = new MyTwitter(rp);
PessoaFisica Pes = new PessoaFisica("emerson2", 1000);
PessoaFisica Pes1 = new PessoaFisica("emerson3", 1001);
PessoaFisica Pes2 = new PessoaFisica("emerson4", 1002);
PessoaFisica Pes3 = new PessoaFisica("emerson5", 1003);

my.criarPerfil(Pes);
my.criarPerfil(Pes1);
my.criarPerfil(Pes2);
my.criarPerfil(Pes3);

my.tweetar("emerson2", "aqui é o emerson2");
my.tweetar("emerson3", "aqui é o emerson3");
my.tweetar("emerson4", "aqui é o emerson4");
my.tweetar("emerson5", "aqui é o emerson5");
my.tweetar("emerson2", "hoje vai dar Brasil!!!");


my.seguir("emerson2", "emerson3");
my.seguir("emerson2", "emerson4");
my.seguir("emerson3", "emerson2");
my.seguir("emerson4", "emerson2");
my.seguir("emerson3", "emerson4");
my.seguir("emerson5", "emerson2");
my.seguir("emerson5", "emerson3");
my.seguir("emerson5", "emerson4");
my.seguir("emerson4", "emerson5");
my.seguir("emerson3", "emerson5");

//my.cancelarPerfil("emerson5");

System.out.println("######################################################################");


System.out.println("EMERSON 2");


System.out.println("Meus tweets :");

for(Tweet t : my.tweets("emerson2")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");



System.out.println("TIMELINE");



for(Tweet t : my.timeline("emerson2")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("SEGUIDORES : " +my.numeroSeguidores("emerson2"));



for(Perfil p : my.seguidores("emerson2")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");



for(Perfil p : my.seguidos("emerson2")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");



System.out.println("EMERSON 3");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("emerson3")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");


for(Tweet t : my.timeline("emerson3")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("emerson3"));

for(Perfil p : my.seguidores("emerson3")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("emerson3")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");

System.out.println("EMERSON 4");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("emerson4")){
	System.out.println(t.getMensagem());
}
System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");

for(Tweet t : my.timeline("emerson4")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("emerson4"));

for(Perfil p : my.seguidores("emerson4")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("emerson4")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");

System.out.println("EMERSON 5");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("emerson5")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");

for(Tweet t : my.timeline("emerson5")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("emerson5"));

for(Perfil p : my.seguidores("emerson5")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("emerson5")){
	System.out.println(p.getUsuario());
};



}

}