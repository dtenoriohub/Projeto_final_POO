package telas;
import java.awt.Font;

import javax.swing.JButton;

import ouvintes.OuvinteBotoesLogin;

public class TelaLogin extends TelaPadrao {

	public TelaLogin() {
		
		setTitulo("Login");
		adicionarBotoes();

	}

	public void adicionarBotoes() {
		
		OuvinteBotoesLogin ov = new OuvinteBotoesLogin(this);
		
		JButton btLogin = new JButton("Login");
		btLogin.setBounds(550, 400, 70, 30);
		
		JButton btNovoUsuario = new JButton("Novo Usuário");
		btNovoUsuario.setBounds(200,400,120,30);
		
		JButton btEsqueciSenha = new JButton("Esqueci minha senha");
		btEsqueciSenha.setFont(new Font("Times new roman",Font.ITALIC,12));
		btEsqueciSenha.setBounds(329, 215, 150, 20);
		
		btLogin.addActionListener(ov);
		btNovoUsuario.addActionListener(ov);
		btEsqueciSenha.addActionListener(ov);
		
		this.add(btLogin);
		this.add(btNovoUsuario);
		this.add(btEsqueciSenha);
		
	}
	
	
}






