package admin;

import java.util.Date;

import usuario.Sexo;
import usuario.Usuario;

public class Administrador extends Usuario {

	public Administrador() {}

	public Administrador(String nome, Sexo sexo, Date dataNascimento, String email, String senha) {
		super(nome, sexo, dataNascimento, email, senha);
	}
}
