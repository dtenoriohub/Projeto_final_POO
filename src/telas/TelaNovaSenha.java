package telas;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.MinimoCaractereException;
import excecoes.SenhaInvalidaException;
import funcionalidades.recuperarSenha.AlterarSenha;

public class TelaNovaSenha extends TelaPadraoRecuperarSenha {

	
	private JTextField tfNovaSenha; 
	private JTextField tfConfirmeSenha;
	private String email;
	
	public TelaNovaSenha() {
		labels();
		fields();
		adicionarBotoes();
		this.setTitle("Nova senha");
		repaint();

	}

	public TelaNovaSenha(String email) {
		this();
		this.email = email;
	}
	
	public void labels() {

		JLabel lbNovaSenha = new JLabel("Nova Senha");
		JLabel lbConfirmeSenha = new JLabel("Confirme a senha");
		lbNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConfirmeSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lbNovaSenha.setBounds(205, 50, 80, 30);
		lbConfirmeSenha.setBounds(190, 120, 150, 30);
		this.add(lbNovaSenha);
		this.add(lbConfirmeSenha);

	}

	public void fields() {

		tfNovaSenha = new JTextField();
		tfConfirmeSenha = new JTextField();

//		tfNovaSenha.setName("tfNovaSenha");
//		tfConfirmeSenha.setName("tfConfirmeSenha");

		tfNovaSenha.setBounds(125, 80, 230, 30);
		tfConfirmeSenha.setBounds(125, 150, 230, 30);
		
		this.add(tfNovaSenha);
		this.add(tfConfirmeSenha);

	}

	public void adicionarBotoes() {


		JButton btConfirmar = new JButton("Salvar");
		btConfirmar.setName("btConfirmar");

		btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btConfirmar.setBounds(350, 220, 100, 30);

		this.add(btConfirmar);
		btConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(tfConfirmeSenha.getText() + " " + tfNovaSenha.getText());
				String msg = "";
				try {
					if(tfNovaSenha.getText().length() < 6 && tfConfirmeSenha.getText().length() < 6) {
						throw new MinimoCaractereException();
					}
					if(tfNovaSenha.getText().equals(tfConfirmeSenha.getText())) {
						
						msg = "Senha alterada com sucesso!";
						
						new AlterarSenha(email, tfNovaSenha.getText()); //aqui ta dando problema
					}
				} 
				catch (Exception ex) {
					ex.printStackTrace();
					msg = ex.getMessage();
				}
				finally {
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});


	}

}
