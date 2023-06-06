package telas.terceiraFase;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaAgendarCorridaDepois extends TelaAgendarCorridasPadrao{
	
	private JFormattedTextField fdData;
	private JFormattedTextField fdHorario;


	
	public TelaAgendarCorridaDepois() {
		
		setTitle("Agendar corridas para Depois");
		
	}

	
	public void labels() {
		super.labels();
		
		JLabel lbData = new JLabel("Data");
		JLabel lbHorario = new JLabel("Horário");
		
		lbData.setBounds(100,225,200,30);
		lbData.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		lbHorario.setBounds(100,270,200,30);
		lbHorario.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		this.add(lbData);
		this.add(lbHorario);
		
		
		
		
	}
	
	public void fields() {
		super.fields();
		
		//mascara para data formatada
		MaskFormatter mascaradata = null;
		
		try {
			mascaradata = new MaskFormatter(" ##/##/####");
		}catch (ParseException e) {
			System.err.println("erro na formatação: "+ e.getMessage());
		}
		
		fdData = new JFormattedTextField(mascaradata);
		fdData.setBounds(150, 225, 75, 30);
		fdData.setName("fdData");
		this.add(fdData);
		
		//mascara formatada para horario
		
		
		MaskFormatter mascaraHorario = null;
		
		try {
			mascaraHorario = new MaskFormatter(" ##:##");
		}catch (ParseException e) {
			System.err.println("erro na formatação: "+ e.getMessage());
		}
		
		fdHorario = new JFormattedTextField(mascaraHorario);
		fdHorario.setBounds(165, 270, 50, 30);
		fdHorario.setName("fdData");
		this.add(fdHorario);
		
	}


	public String getFdData() {
		return fdData.getText();
	}


	public String getFdHorario() {
		return fdHorario.getText();
	}
	
	
	
	
	
}
