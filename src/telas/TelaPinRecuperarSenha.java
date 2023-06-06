package telas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class TelaPinRecuperarSenha extends TelaPadraoRecuperarSenha {

	private JFormattedTextField fdPinFormatado; 
	private MaskFormatter mascaraPin;
	private String pinGerado;
	private String emailRecuperar;
	
	public TelaPinRecuperarSenha(String pinGerado, String emailRecuperar) {
		this.emailRecuperar = emailRecuperar;
		this.pinGerado = pinGerado;
		labels();
		fields();
		repaint();
		adicionarBotoes();
		this.setTitle("Pin de recuperação");
		//repaint();

	}

	public void labels() {
		JLabel lbPinEnviado = new JLabel("Digite o pin enviado por email");
		lbPinEnviado.setName("pinEnviado");
		lbPinEnviado.setBounds(95, 80, 320, 30);
		lbPinEnviado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.add(lbPinEnviado);

	}

	public void fields() {

		
		try {
			mascaraPin = new MaskFormatter("######");
		} catch (ParseException e) {
			System.err.println("erro na formatação: " + e.getMessage());
		}
		fdPinFormatado = new JFormattedTextField(mascaraPin);
		fdPinFormatado.setFont(new Font("Tahoma",Font.PLAIN,18));
		fdPinFormatado.setName("fdPinFormatado");
		fdPinFormatado.setBounds(175, 140, 150, 40);
		this.add(fdPinFormatado);

	}
	public void adicionarBotoes() {
		
		JButton btVerificarPin = new JButton("Verificar");
		btVerificarPin.setName("btVerificarPin");
		btVerificarPin.setFont(new Font("Tahoma",Font.PLAIN,14));
		btVerificarPin.setBounds(350, 220, 100, 30);
		
		btVerificarPin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pinGerado.equals(fdPinFormatado.getText()))
						new TelaNovaSenha(emailRecuperar);

				//
			}
		});
		
		this.add(btVerificarPin);
	}
	public String getFdPin() {
		return fdPinFormatado.getText();
	}
}
