package excecoes;

public class MinimoCaractereException extends Exception {

	public String getMessage() {
		return "Tamanho mínimo de senha não atingido";
	}
	
}
