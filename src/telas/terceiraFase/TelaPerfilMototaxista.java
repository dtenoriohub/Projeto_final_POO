package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;

import telas.TelaPerfilPadrao;

public class TelaPerfilMototaxista extends TelaPerfilPadrao{
	
	
	public TelaPerfilMototaxista() {
		setTitle("MotoTaxista");
		adicionarBotoes();
		
	}
	

	public void adicionarBotoes() {
		JButton jbListarCorridas = new JButton("Listar Corridas");
		JButton jbComprarCreditosReivindicacao = new JButton("Comprar Creditos de Reivindicação");
		
		jbListarCorridas.setBounds(200,100,200,45);
		jbListarCorridas.setFont(new Font("Tahoma",Font.PLAIN,16));
		jbComprarCreditosReivindicacao.setBounds(150,200,300,45);
		jbComprarCreditosReivindicacao.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		this.add(jbListarCorridas);
		this.add(jbComprarCreditosReivindicacao);
		
		
		
	}
	
}
