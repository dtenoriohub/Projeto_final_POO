package telas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaListarCorridas extends JFrame {

	public TelaListarCorridas() {

		//necessario layout
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Todas As Corridas");
		//setLayout(null);
		adicionarTabelaCorridas();
		repaint();
		setVisible(true);

	}

	public void adicionarTabelaCorridas() {
		
		
		String dados[][] = { { "101", "Amit", "670000" }, 
				{ "102", "Jai", "780000" }, 
				{ "101", "Sachin", "700000" } };

		String coluna[] = { "ID", "DATA", "TIPO" };
		JTable jtTabela = new JTable(dados, coluna);
		jtTabela.setBounds(30, 40, 200, 300);
		JScrollPane spRolagem = new JScrollPane(jtTabela);
		
		this.add(spRolagem);
		

	}

}
