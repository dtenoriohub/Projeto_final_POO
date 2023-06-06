package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import admin.Administrador;
import admin.CentralDeInformacoes;
import admin.Persistencia;
import excecoes.EmailExistenteException;
import excecoes.MinimoCaractereException;
import excecoes.MinimoNumeroException;
import funcionalidades.RecuperarPersistencia;
import mototaxista.Mototaxista;
import passageiro.Passageiro;
import telas.TelaCadastro;
import usuario.Sexo;
import usuario.Usuario;

public class OuvinteBotaoCadastro implements ActionListener{

	private TelaCadastro tela;

	public OuvinteBotaoCadastro(TelaCadastro tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central =  p.recuperarCentral();
		//System.out.println(tela.getCampoTelefone().length());
		boolean cleytao = true;
		try {
			
			Usuario u = central.recuperarUsuarioPeloEmail(tela.getFdEmail());
			if(u != null)
				throw new EmailExistenteException(tela.getFdEmail());
			//Inserir msg de explicação //
			if(tela.getFdSenha().length() < 6)
				throw new MinimoCaractereException();
			if(tela.getCampoTelefone().length() < 15)
				throw new MinimoNumeroException();
			if(tela.getJcTipoDeUsuario().equals("Passageiro"))
				u = new Passageiro();
			else if(tela.getJcTipoDeUsuario().equals("Mototaxista"))
				u = new Mototaxista();
			else
				u = new Administrador();
			
			if(tela.getJcSexo().equals("Masculino"))
				u.setSexo(Sexo.MASCULINO);
			else
				u.setSexo(Sexo.FEMININO);
			
			u.setNome(tela.getNomeUsuario());
			u.setSenha(tela.getFdSenha());
			u.setDataNascimento(tela.getFdData());
			u.setEmail(tela.getFdEmail());
				
			central.adicionarUsuario(u);
			p.salvarCentral(central);
			
		}
		catch(Exception e2) {
			cleytao = false;
			System.out.println(e2.getMessage());
		}
		finally {
			//Verificando se há a necessidade de limpar os campos ou fechar a tela
			if(cleytao) 
				tela.dispose();
			else
				tela.limparFields();
		}

		

	}

}
