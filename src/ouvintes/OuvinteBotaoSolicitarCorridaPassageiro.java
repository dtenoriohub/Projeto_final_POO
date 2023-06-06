package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.terceiraFase.TelaAgendarCorridaAgora;
import telas.terceiraFase.TelaAgendarCorridaDepois;
import telas.terceiraFase.TelaAgendarCorridasPadrao;
import telas.terceiraFase.TelaSolicitarCorrida;

public class OuvinteBotaoSolicitarCorridaPassageiro implements ActionListener{

	private TelaSolicitarCorrida tela;
	
	public OuvinteBotaoSolicitarCorridaPassageiro(TelaSolicitarCorrida tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		String botao = e.getActionCommand();
		
		if(botao.equals(tela.getJbAgendarAgora()))
			new TelaAgendarCorridaAgora();
		else if (botao.equals(tela.getJbAgendarParaOutraData()))
			new TelaAgendarCorridaDepois();
		//tratar o else ..??
	}
	
}
