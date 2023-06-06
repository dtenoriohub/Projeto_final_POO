package excecoes;

public class SenhaInvalidaException extends Exception {

	public String getMessage() {
		return "Senha inválida";
	}	
}
