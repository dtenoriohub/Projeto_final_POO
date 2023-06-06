package mainTestes;

import javax.swing.JOptionPane;

import admin.CentralDeInformacoes;
import admin.Persistencia;
import telas.TelaCadastro;
import telas.TelaLogin;
import telas.TelaPadrao;

public class Main {

	public static void main(String[] args) {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		TelaPadrao tela;
		
		boolean admNaoCadastrado = (central.getTodosOsUsuarios().size() == 0);

		if(admNaoCadastrado) {
			JOptionPane.showMessageDialog(null, "Cadastro de ADM");
			tela = new TelaCadastro();
		}
		
		else{
			tela = new TelaLogin();
			tela.repaint();
		}
		
		
	}
}
