package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import admin.CentralDeInformacoes;
import admin.Persistencia;
import excecoes.EmailExistenteException;
import excecoes.UsuarioInexistenteException;
import funcionalidades.recuperarSenha.RecuperarSenha;
import telas.TelaEmailRecuperar;

public class OuvinteBotaoEsqueciMinhaSenha implements ActionListener {

	private TelaEmailRecuperar tela;

	public OuvinteBotaoEsqueciMinhaSenha(TelaEmailRecuperar tela) {
		this.tela = tela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		Object u = central.recuperarUsuarioPeloEmail(tela.getFdEmailRecuperar());
		try {
			if(u == null)
				throw new UsuarioInexistenteException(tela.getFdEmailRecuperar());
			RecuperarSenha.enviarPin(tela.getFdEmailRecuperar());
			tela.dispose();
			
		} 
		catch (Exception ex) {
			JOptionPane.showMessageDialog(tela, ex.getMessage());
			tela.limparFields();
		}


	}
}
