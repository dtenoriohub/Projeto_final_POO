package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class TelaAgendarCorridasPadrao extends JFrame{

	private JTextField fdLocalPartida = null;
	private JTextField fdLocalDestino = null;
	
	
	public TelaAgendarCorridasPadrao() {
		
		
		setSize(700, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		labels();
		fields();
		adicionarBotoes();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		setVisible(true);		
		repaint();

	}
	
	public void labels() {
		
		JLabel lbLocalPartida = new JLabel("Local de Partida");
		JLabel lbLocalDestino = new JLabel("Local de Destino");
		
		lbLocalPartida.setBounds(100,40,200,100);
		lbLocalPartida.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbLocalDestino.setBounds(100,110,200,100);
		lbLocalDestino.setFont(new Font("Tahoma",Font.PLAIN,16));
		this.add(lbLocalPartida);
		this.add(lbLocalDestino);
		
		
	}
	
	public void fields() {
		
		fdLocalPartida = new JTextField();
		fdLocalDestino = new JTextField();
		
		fdLocalPartida.setBounds(100,110,400,30);
		fdLocalDestino.setBounds(100,180,400,30);
		
		this.add(fdLocalPartida);
		this.add(fdLocalDestino);
		
	}
	
	public void adicionarBotoes() {
		
		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(550,400,95,30);
		btConfirmar.setFont(new Font("Tahoma",Font.PLAIN,13));
		this.add(btConfirmar);
	}

	public String getFdLocalPartida() {
		return fdLocalPartida.getText();
	}

	public String getFdLocalDestino() {
		return fdLocalDestino.getText();
	}
	
	
}
