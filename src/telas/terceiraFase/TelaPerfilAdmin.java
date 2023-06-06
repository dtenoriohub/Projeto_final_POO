package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;

import ouvintes.OuvinteTelaPerfilAdministrador;
import telas.TelaPerfilPadrao;

public class TelaPerfilAdmin extends TelaPerfilPadrao{

	private JButton btListarUsuarios;
	private JButton btCreditoReivin;
	private JButton btCaixa;
	private JButton btListarCorridas;

	public TelaPerfilAdmin() {
		this.setTitle("Painel do Administrador");
		this.adicionarBotoes();
	}

	public void adicionarBotoes() {

		OuvinteTelaPerfilAdministrador ov = new OuvinteTelaPerfilAdministrador(this);
		
		btListarUsuarios = new JButton("Listar Usuários");
		btCreditoReivin = new JButton("Credito de Reivindicação");
		btCaixa = new JButton("Caixa");
		btListarCorridas = new JButton("Listar Corridas");

		btListarUsuarios.setBounds(220,90,160,45);
		btCreditoReivin.setBounds(205,190,190,45);
		btCaixa.setBounds(220,290,160,45);
		btListarCorridas.setBounds(220,390,160,45);

		btListarUsuarios.setFont(new Font("Tahoma",Font.PLAIN,15));
		btCreditoReivin.setFont(new Font("Tahoma",Font.PLAIN,15));
		btListarCorridas.setFont(new Font("Tahoma",Font.PLAIN,15));
		btCaixa.setFont(new Font("Tahoma",Font.PLAIN,15));

		btListarUsuarios.addActionListener(ov);
		btCaixa.addActionListener(ov);
		btCreditoReivin.addActionListener(ov);
		btListarCorridas.addActionListener(ov);
		
		this.add(btListarCorridas);
		this.add(btCaixa);
		this.add(btCreditoReivin);
		this.add(btListarUsuarios);

	}

	public String getBtListarUsuarios() {
		return btListarUsuarios.getText();
	}

	public String getBtCreditoReivin() {
		return btCreditoReivin.getText();
	}

	public String getBtCaixa() {
		return btCaixa.getText();
	}

	public String getBtListarCorridas() {
		return btListarCorridas.getText();
	}





}
