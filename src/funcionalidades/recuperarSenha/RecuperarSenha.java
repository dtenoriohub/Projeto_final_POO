package funcionalidades.recuperarSenha;

import java.io.File;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import telas.TelaNovaSenha;
import telas.TelaPinRecuperarSenha;

public abstract class RecuperarSenha {

	private static String pinGerado = "";

	public static void gerarPin() {

		Random random = new Random();
		for(int i = 0; i < 6; i ++)
			pinGerado += String.valueOf(random.nextInt(9));

	}

	public static void enviarPin(String email) {
		gerarPin();

		String msg = pinGerado;
		String subject = "Código de recuperação";
		String to = email;

		String host = "smtp.gmail.com";
		String sender = "pooprojeto2022@gmail.com";
		String password = "exdcdaofmstyrrfk";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart body = new MimeBodyPart();
			body.setText(msg);

			Transport.send(message);
			//JOptionPane.showMessageDialog(null, "");
			new TelaPinRecuperarSenha(pinGerado, email);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	


}
