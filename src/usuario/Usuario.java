package usuario;

import java.util.Date;

public abstract class Usuario {

	private String nome;
	private Sexo sexo;
	private Date dataNascimento;
	private String email;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(String nome, Sexo sexo, Date dataNascimento, String email, String senha) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString() {
			
		return nome;
	}
	
	
	
}
