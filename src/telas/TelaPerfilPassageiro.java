package telas;
import java.awt.Font;

import javax.swing.JButton;

import ouvintes.OuvinteTelaPerfilPassageiro;

public class TelaPerfilPassageiro extends TelaPerfilPadrao{
	
	private JButton btSolicitarCorrida;
	private JButton btListarCorridas;
	
	public TelaPerfilPassageiro() {
		
		setTitle("Passageiro");
		adicionarBotoes();
		this.repaint();
	}
	
	
	public void adicionarBotoes() {
		
		
		btSolicitarCorrida = new JButton("Solicitar Corrida");
		btSolicitarCorrida.setFont(new Font("Tahoma",Font.PLAIN,17));
		btSolicitarCorrida.setBounds(190,100,200,50);
		
		btSolicitarCorrida.addActionListener(new OuvinteTelaPerfilPassageiro(this));
		
		this.add(btSolicitarCorrida);
		
		btListarCorridas = new JButton("Listar Corridas");
		btListarCorridas.setFont(new Font("Tahoma",Font.PLAIN,17));
		btListarCorridas.setBounds(174,200,230,50);
		
		btListarCorridas.addActionListener(new OuvinteTelaPerfilPassageiro(this));

		this.add(btListarCorridas);
		
	}
	
	public String getBtSolicitarCorrida() {
		return btSolicitarCorrida.getText();
	}
	public String getBtListarCorridas() {
		return btListarCorridas.getText();
	}
	
}

