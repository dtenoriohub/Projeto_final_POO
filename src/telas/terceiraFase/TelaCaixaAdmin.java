package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCaixaAdmin extends JFrame{
	JTextField fdPeriodo;
	JTextField fdEmail ;
	
	public TelaCaixaAdmin() {
		
		
		setTitle("Caixa");
		setSize(600,500);
		setLocationRelativeTo(null);
		fields();
		labels();
		adicionarBotoes();
		adicionarCheckBox();
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
	
	public void labels() {
		JLabel lbEmail = new JLabel();
		
	}
	
	public void fields() {
		fdEmail = new JTextField();
		fdEmail.setBounds(70,150,400,30);
		fdEmail.setName("fdEmail");
		this.add(fdEmail);
		
		fdPeriodo = new JTextField();
		fdPeriodo.setBounds(70,250,100,30);
		fdPeriodo.setName("fdPeriodo");
		this.add(fdPeriodo);
	}
	
	

	public void adicionarCheckBox() {
		
		JCheckBox chTodosOsMotoristas = new JCheckBox("Todos Os Motoristas",false);
		JCheckBox chMotoristaEspecifico = new JCheckBox("Motorista Especifico (E-mail)",false);
		JCheckBox chPeriodoTempo = new JCheckBox("Periodo de tempo",false);
		
		
		chTodosOsMotoristas.setBounds(50,50,200,50);
		chTodosOsMotoristas.setFont(new Font("Tahoma",Font.BOLD,15));
		chMotoristaEspecifico.setBounds(50,100,250,50);
		chMotoristaEspecifico.setFont(new Font("Tahoma",Font.BOLD,15));
		chPeriodoTempo.setBounds(50,200,200,50);
		chPeriodoTempo.setFont(new Font("Tahoma",Font.BOLD,15));
		this.add(chTodosOsMotoristas);
		this.add(chMotoristaEspecifico);
		this.add(chPeriodoTempo);
	
	}
	
	public void adicionarBotoes() {
		JButton btGerarRelatorio = new JButton("Gerar Relatorio");
		btGerarRelatorio.setBounds(400,300,140,100);
		btGerarRelatorio.setFont(new Font("Tahoma",Font.BOLD,14));
		this.add(btGerarRelatorio);
	}

	public JTextField getFdPeriodo() {
		return fdPeriodo;
	}

	public JTextField getFdEmail() {
		return fdEmail;
	}

	
	

}

