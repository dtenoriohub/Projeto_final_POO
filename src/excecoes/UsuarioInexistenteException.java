package excecoes;

public class UsuarioInexistenteException extends Exception {

	private String email;
	
	public UsuarioInexistenteException(String email) {
		this.email = email;
	}

	public String getMessage() {
		return "E-mail " + email + " não cadastrado!";
	}
	
}
