package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import telas.TelaPerfilPadrao;

public class OuvinteMenuTelaPerfilPadrao implements ActionListener {

	
	private TelaPerfilPadrao tela;
	private String itemMenu;
	
	public OuvinteMenuTelaPerfilPadrao(TelaPerfilPadrao tela) {
		this.tela = tela;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		itemMenu = e.getActionCommand();
		System.out.println(itemMenu);
		if(itemMenu.equals("informações"))
			JOptionPane.showMessageDialog(tela, "Ausencia de tela");

	}
}
