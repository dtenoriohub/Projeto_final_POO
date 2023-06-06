package excecoes;

public class EmailExistenteException extends Exception{

	private String email;
	
	public EmailExistenteException(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return "O e-mail "+ email +" já está sendo usado";
	}
	
}
