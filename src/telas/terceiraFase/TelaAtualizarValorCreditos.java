package telas.terceiraFase;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaAtualizarValorCreditos	extends JFrame {
	
	public TelaAtualizarValorCreditos() {
		
		setTitle("Valor dos Creditos");
		setSize(400,200);
		setLocationRelativeTo(null);
		setLayout(null);
		labels();
		fields();
		adicionarBotoes();
		setVisible(true);
		
		
		
	}
	
	public void labels() {
		JLabel lbValorCreditos = new JLabel("Valor dos Creditos");
		lbValorCreditos.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbValorCreditos.setBounds(125,10,150,40);
		this.add(lbValorCreditos);
	
	}
	
	public void fields() {
		
		JTextField tfValorCreditos = new JTextField();
		tfValorCreditos.setName("tfValorCreditos");
		tfValorCreditos.setBounds(115,50,150,30);
		this.add(tfValorCreditos);
		
	}
	
	public void adicionarBotoes() {
		
		JButton btConfirmarCreditos = new JButton("Confirmar");
		btConfirmarCreditos.setBounds(150,90,100,30);
		this.add(btConfirmarCreditos);
		
		
	}
	
	
	
}
