package telas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


// telas cadastro e login herdarão

public class TelaPadrao extends JFrame {

	private JLabel titulo = new JLabel(getTitle());

	private JTextField fdEmail;
	private JTextField fdSenha;

	public TelaPadrao() {

		this.setSize(700, 500);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Essa linha acima pode ser um problema na hora de fechar uma janela.
		labels();
		fields();
		this.setVisible(true);

	}

	public void labels() {

		JLabel lbEmail = new JLabel("E-mail");
		JLabel lbSenha = new JLabel("Senha");

		titulo.setBounds(0, 20, 700, 50);
		titulo.setFont(new Font("Tahoma", Font.ITALIC, 30));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setBackground(Color.GRAY);
		titulo.setOpaque(true);

		lbEmail.setBounds(100, 130, 50, 30);
		lbSenha.setBounds(100, 180, 50, 30);

		this.add(titulo);
		this.add(lbEmail);
		this.add(lbSenha);

	}

	public void fields() {

		fdEmail = new JTextField();
		fdSenha = new JTextField();

		fdEmail.setBounds(170, 130, 310, 30);
		fdSenha.setBounds(170, 180, 310, 30);

		//Inserindo ouvintes

		this.add(fdEmail);
		this.add(fdSenha);

	}

	public void setTitulo(String t) {
		titulo.setText(t);
	}
	public String getFdEmail() {
		return fdEmail.getText();
	}
	public String getFdSenha() {
		return fdSenha.getText();
	}
	public void setFdEmail(String fdEmail) {
		this.fdEmail.setText(fdEmail);
	}
	public void setFdSenha(String fdSenha) {
		this.fdSenha.setText(fdSenha);
	}
	public void limparFields() {
		fdEmail.setText("");
		fdSenha.setText("");
	}

}
