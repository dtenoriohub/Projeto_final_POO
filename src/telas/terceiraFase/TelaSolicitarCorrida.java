package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import ouvintes.OuvinteBotaoSolicitarCorridaPassageiro;

public class TelaSolicitarCorrida extends JFrame{
	
	private JButton jbAgendarAgora;
	private JButton jbAgendarParaOutraData; 
	
	public TelaSolicitarCorrida() {
		
		setSize(400,300);
		setTitle("Solicitar Corridas");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		adicionarBotoes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public void adicionarBotoes() {
		
		OuvinteBotaoSolicitarCorridaPassageiro ov = new OuvinteBotaoSolicitarCorridaPassageiro(this);
		
		jbAgendarAgora = new JButton("Agendar para Agora");
		jbAgendarParaOutraData = new JButton("Agendar para outra data");
		
		
		jbAgendarAgora.setBounds(120,50,160,45);
		jbAgendarAgora.setFont(new Font("Tahoma",Font.PLAIN,14));
		jbAgendarParaOutraData.setFont(new Font("Tahoma",Font.PLAIN,14));
		jbAgendarParaOutraData.setBounds(105,120,190,45);
		
		jbAgendarAgora.addActionListener(ov);
		jbAgendarParaOutraData.addActionListener(ov);
		
		this.add(jbAgendarAgora);
		this.add(jbAgendarParaOutraData);
		
	}

	public String getJbAgendarAgora() {
		return jbAgendarAgora.getText();
	}

	public String getJbAgendarParaOutraData() {
		return jbAgendarParaOutraData.getText();
	}

	
}
