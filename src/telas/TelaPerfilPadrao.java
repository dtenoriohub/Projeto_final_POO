package telas;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ouvintes.OuvinteMenuTelaPerfilPadrao;

public abstract class TelaPerfilPadrao extends JFrame{
	
	//inserir ouvintes;
	
	public TelaPerfilPadrao() {
		
		setTitle("Tela usuario");
		setSize(600,600);
		setLocationRelativeTo(null);
		setLayout(null);
		menuBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		System.out.println("teste");
		setVisible(true);
		
	}

	public void menuBar() {
		OuvinteMenuTelaPerfilPadrao ov = new OuvinteMenuTelaPerfilPadrao(this);
		
		JMenuBar mbMenu = new JMenuBar();
		setJMenuBar(mbMenu);
		
		JMenu menuPerfil = new JMenu("Perfil");
		menuPerfil.setFont(new Font("Tahoma",Font.PLAIN,15));
		
		mbMenu.add(menuPerfil); 
		
		
		JMenuItem mIBotao = new JMenuItem("informações");
		mIBotao.setFont(new Font("Tahoma",Font.PLAIN,15));
		
		//inserirndo ouvinte
		mIBotao.addActionListener(ov);
		
		menuPerfil.add(mIBotao);
		
		JMenuItem editarPerfil = new JMenuItem("editar Perfil");
		editarPerfil.setFont(new Font("Tahoma",Font.PLAIN,15));
		
		//inserindo ouvinte
		editarPerfil.addActionListener(ov);
		menuPerfil.add(editarPerfil);
		
	}
	
	
	
	
	
	
	

}
