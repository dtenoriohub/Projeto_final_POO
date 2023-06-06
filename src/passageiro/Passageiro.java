package passageiro;

import java.util.Date;
import usuario.Sexo;
import usuario.Usuario;

public class Passageiro extends Usuario {

	
	public Passageiro() {
		super();
	}
	
	public Passageiro(String nome, Sexo sexo, Date dataNascimento, String email, String senha) {
		super(nome, sexo, dataNascimento, email, senha);
		
	}
	
}
