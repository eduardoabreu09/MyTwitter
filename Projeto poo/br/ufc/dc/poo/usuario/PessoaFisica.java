package br.ufc.dc.poo.usuario;

import java.util.Vector;


public class PessoaFisica extends Perfil{
	private long cpf;

	public PessoaFisica(String usuario, long cpf){
		super(usuario);
		this.cpf = cpf;

	}

	public void setCpf(long cpf){
		this.cpf = cpf;
	}

	public long getCpf(){
		return this.cpf;

	}


}