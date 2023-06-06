package admin;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import passageiro.Passageiro;

import javax.mail.Multipart;
import java.io.File;

public class Mensageiro {

	public void enviarHistóricoDeCorrida(Passageiro passageiro) {


		String msg = "Relatório de viagens de " + passageiro.getNome();

		String subject = "Relatório";
		String to = passageiro.getEmail();
		
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

			MimeBodyPart attach = new MimeBodyPart();
			attach.attachFile(new File("/home/rharhuky/eclipse-workspace/testesDoProjetoPOO/relatorioPassageiro.pdf"));
			multipart.addBodyPart(body);
			multipart.addBodyPart(attach);
			message.setContent(multipart);

			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Message sent!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

//}
