package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import admin.CentralDeInformacoes;
import admin.Persistencia;
import excecoes.SenhaInvalidaException;
import excecoes.UsuarioInexistenteException;
import mototaxista.Mototaxista;
import passageiro.Passageiro;
import telas.TelaCadastro;
import telas.TelaEmailRecuperar;
import telas.TelaLogin;
import telas.TelaPerfilPassageiro;
import telas.terceiraFase.TelaPerfilAdmin;
import telas.terceiraFase.TelaPerfilMototaxista;
import usuario.Usuario;

public class OuvinteBotoesLogin implements ActionListener {

	private TelaLogin tela;

	public OuvinteBotoesLogin(TelaLogin tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		
		String botao = e.getActionCommand();
		
		switch (botao) {
		
		case "Login":
			Usuario u = central.recuperarUsuarioPeloEmail(tela.getFdEmail());
			// Testar a instancia System.out.println(u instanceof Passageiro);
			try {
				
				if(u == null)
					throw new UsuarioInexistenteException(tela.getFdEmail());
				if(!u.getSenha().equals(tela.getFdSenha()))
					throw new SenhaInvalidaException();
				JOptionPane.showMessageDialog(tela, "Deu tudo certo", "Tela de teste", JOptionPane.INFORMATION_MESSAGE);
				
				if(u instanceof Passageiro) {
					new TelaPerfilPassageiro();
				}
				else if(u instanceof Mototaxista) {
					new TelaPerfilMototaxista();
				}
				else
					new TelaPerfilAdmin();
					
				tela.dispose();
				//System.exit(0); !!!
				
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(tela, ex.getMessage());
				tela.limparFields(); 
			}
			
			break;
			
		case "Esqueci minha senha":
			tela.dispose();
			new TelaEmailRecuperar();
			break;
			
		case "Novo Usuário":
			tela.limparFields();
			new TelaCadastro();
			break;
		}
		
		
		//tela.dispose();
	}

}
