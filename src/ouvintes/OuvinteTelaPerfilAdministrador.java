package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import funcionalidades.Ausente;
import telas.terceiraFase.TelaAtualizarValorCreditos;
import telas.terceiraFase.TelaCaixaAdmin;
import telas.terceiraFase.TelaPerfilAdmin;

public class OuvinteTelaPerfilAdministrador implements ActionListener {

	private TelaPerfilAdmin tela;

	public OuvinteTelaPerfilAdministrador(TelaPerfilAdmin tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String botao = e.getActionCommand();

		switch (botao) {

		case "Listar Usuários":
			Ausente.tela();
			break;


		case "Credito de Reivindicação":
			new TelaAtualizarValorCreditos();
			break;

		case "Caixa":
			new TelaCaixaAdmin();
			break;
		case "Listar Corridas":
			Ausente.tela();
			break;


		}

	}
}
