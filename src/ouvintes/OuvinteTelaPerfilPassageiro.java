package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.TelaListarCorridas;
import telas.TelaPerfilPassageiro;
import telas.terceiraFase.TelaSolicitarCorrida;

public class OuvinteTelaPerfilPassageiro implements ActionListener {

	private TelaPerfilPassageiro tela;
	
	public OuvinteTelaPerfilPassageiro(TelaPerfilPassageiro tela) {
		this.tela = tela;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String botao = e.getActionCommand();
		
		
		if(botao.equals(tela.getBtListarCorridas()))
			new TelaListarCorridas();
		
		else if(botao.equals(tela.getBtSolicitarCorrida())) {
			new TelaSolicitarCorrida();
		}
	}
}
