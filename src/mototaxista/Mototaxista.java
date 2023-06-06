package mototaxista;

import java.util.Date;

import usuario.Sexo;
import usuario.Usuario;

public class Mototaxista extends Usuario {

	private int numeroCreditos;
	
	public Mototaxista() {}

	public Mototaxista(String nome, Sexo sexo, Date dataNascimento, String email, String senha) {
		super(nome, sexo, dataNascimento, email, senha);
	}
	
}
