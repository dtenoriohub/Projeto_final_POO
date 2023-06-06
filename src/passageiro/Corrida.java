package passageiro;

import java.util.Date;

import usuario.Sexo;

public class Corrida {

	private long id;
	private String enderecoPartida;
	private String enderecoDestino;
	private Passageiro requerente;
	private Date dadosSolicitacao;
	
	public Corrida() {
		id = System.currentTimeMillis();
		dadosSolicitacao = new Date();
	}

	public Corrida(String enderecoPartida, String enderecoDestino, Passageiro requerente) {
		this.enderecoPartida = enderecoPartida;
		this.enderecoDestino = enderecoDestino;
		this.requerente = requerente;
		id = System.currentTimeMillis();
		dadosSolicitacao = new Date();
	}
	public Date getDadosSolicitacao() {
		return dadosSolicitacao;
	}

	public long getId() {
		return id;
	}

	public String getEnderecoPartida() {
		return enderecoPartida;
	}

	public void setEnderecoPartida(String enderecoPartida) {
		this.enderecoPartida = enderecoPartida;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public Passageiro getRequerente() {
		return requerente;
	}

	public void setRequerente(Passageiro requerente) {
		this.requerente = requerente;
	}
	
	public String toString() {
		String parametro =  requerente.getSexo() == Sexo.FEMININO
				? "pegá-la"
				: "pegá-lo";
		
		String info = String.format("<%s> pede para %s em <%s>",
				requerente.getNome(), parametro, enderecoPartida);
		return info;
	}
	
}
