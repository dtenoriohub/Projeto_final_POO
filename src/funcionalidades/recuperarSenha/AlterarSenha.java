package funcionalidades.recuperarSenha;

import admin.CentralDeInformacoes;
import admin.Persistencia;
import usuario.Usuario;

public class AlterarSenha {

	private String email;
	private String senha;
	
	public AlterarSenha(String email, String senha) {
		this.email = email;
		this.senha = senha;
		alterarSenha();
	}
	
	public void alterarSenha() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes c = p.recuperarCentral();
		c.atualizarSenhaUsuario(email, senha);
		
		
		p.salvarCentral(c);
	}
	
}
