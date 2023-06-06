package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ouvintes.OuvinteBotaoEsqueciMinhaSenha;

public class TelaEmailRecuperar extends TelaPadraoRecuperarSenha {

	private JTextField fdEmailRecuperar;
	private JButton btEnviarPin;
	
	public TelaEmailRecuperar() {
		adicionarBotoes();
		labels();
		this.setTitle("Enviar Email para recuperação");
		fields();
		repaint();
	}
	public void fields() {
		
		fdEmailRecuperar = new JTextField();
		fdEmailRecuperar.setName("fdEmailRecuperar");
		fdEmailRecuperar.setBounds(130,130,235,30);
		this.add(fdEmailRecuperar);
	}
	public void labels() {

		JLabel lbEmailRecuperar = new JLabel("E-mail para recuperar senha");
		
		lbEmailRecuperar.setBounds(95, 80, 350, 30);
		lbEmailRecuperar.setFont(new Font("Tahoma",Font.PLAIN,24));
		this.add(lbEmailRecuperar);

	}
	public void adicionarBotoes() {
		
		OuvinteBotaoEsqueciMinhaSenha ov = new OuvinteBotaoEsqueciMinhaSenha(this);
		
		btEnviarPin = new JButton("Enviar");
		btEnviarPin.setName("btEnviarPin");
		btEnviarPin.setBounds(390, 200, 70, 30);
		btEnviarPin.addActionListener(ov); //
		
		this.add(btEnviarPin);
	}
	
	public String getFdEmailRecuperar() {
		return fdEmailRecuperar.getText();
	}

	public void limparFields() {
		fdEmailRecuperar.setText("");
	}
}
