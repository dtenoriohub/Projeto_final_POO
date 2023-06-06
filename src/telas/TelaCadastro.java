package telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import funcionalidades.RecuperarPersistencia;
import funcionalidades.recuperarSenha.RecuperarSenha;
import ouvintes.OuvinteBotaoCadastro;

public class TelaCadastro extends TelaPadrao {

	private JTextField fdNome;
	private JFormattedTextField fdTelefone;
	private JFormattedTextField fdData;
	private JComboBox jcSexo;
	private JComboBox jcTipoDeUsuario;

	public TelaCadastro() {

		setTitulo("Cadastro");
		adicionarBotoes();
		AdicionarComboBox();
		repaint();

	}

	public void labels() {
		super.labels();

		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(100, 230, 50, 30);
		this.add(lbNome);

		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(100, 280, 50, 30);
		this.add(lbTelefone);
		
		JLabel lbData = new JLabel("Data de \n nascimento ");
		lbData.setBounds(280, 280, 180, 30);
		this.add(lbData);
		
		JLabel lbSexo = new JLabel("Sexo");
		lbSexo.setBounds(100, 325, 50, 30);
		this.add(lbSexo);
		
		//dividi o jlabel em 2 para ficar alinhado
		JLabel lbTipoDeConta = new JLabel("Tipo de");
		lbTipoDeConta.setBounds(100, 365, 90, 30);
		this.add(lbTipoDeConta);
		JLabel lbTipoDeContaUsuario = new JLabel("Usuário");
		lbTipoDeContaUsuario.setBounds(100, 380, 90, 30);
		this.add(lbTipoDeContaUsuario);
		

	}

	public void fields() {
		super.fields();
		
		fdNome = new JTextField();
		fdNome.setBounds(170, 230, 200, 30);
		fdNome.setName("fdNome"); 
		this.add(fdNome);
		
		//novos fields. 
		
		
//		mascara para data formatada
		MaskFormatter mascaraData = null;
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
		}catch (ParseException e) {
			System.err.println("erro na formatação: "+ e.getMessage());
		}
		
		fdData = new JFormattedTextField(mascaraData);
		fdData.setBounds(405, 280, 75, 30);
		fdData.setName("fdData");
		
		
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraTelefone = new MaskFormatter("(##)# #### ####");
		} catch (ParseException e) {
			System.err.println("erro na formatação: "+ e.getMessage());
		}
		
		//alterei para fdTelefone(ficar padrão)
		fdTelefone = new JFormattedTextField(mascaraTelefone);
		fdTelefone.setBounds(170, 280, 100, 30);
		fdTelefone.setName("campoTelefone");
		
		
		
		//inserindo ouvintes;
		//Excluídos 
//		OuvinteEntradaCadastro ouvinteNome = new OuvinteEntradaCadastro(this);
//		OuvinteEntradaCadastro ouvinteTelefone = new OuvinteEntradaCadastro(this);
//		
		//

//		fdNome.addActionListener(ouvinteNome);
//		fdTelefone.addActionListener(ouvinteTelefone);
		this.add(fdData);
		this.add(fdNome);
		this.add(fdTelefone);
		
		
	}

	public void adicionarBotoes() {

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(500, 400, 110, 30);

		// adicionar ouvinteotaoCadastrar

		 OuvinteBotaoCadastro cliqueCadastrar = new OuvinteBotaoCadastro(this);
		 btCadastrar.addActionListener(cliqueCadastrar);

		this.add(btCadastrar);

	}
	//ComboBox para seleção do sexo
	public void AdicionarComboBox() {
		String[] sexo = {"Masculino","Feminino"};
		String[] tipo;
		
		if(RecuperarPersistencia.verificarExitenciaAdmin()) {
			tipo = new String[]{"Administrador"};
		}
		else {
			tipo = new String[]{"Passageiro", "Mototaxista"};
		}
		
		
		jcSexo = new JComboBox(sexo);
		jcSexo.setBounds(170, 325, 90, 30);
		this.add(jcSexo);
		
		jcTipoDeUsuario = new JComboBox(tipo);
		jcTipoDeUsuario.setBounds(170, 370, 100, 30);
		this.add(jcTipoDeUsuario);
	
	}
	
	public Date getFdData() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Date dataDate = null;
		try {
			dataDate = data.parse(fdData.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataDate;
	}
	public String getNomeUsuario() {
		return fdNome.getText();
	}
	public String getCampoTelefone() {
		return fdTelefone.getText();
	}
	public String getJcSexo() {
		return jcSexo.getSelectedItem().toString();
	}
	public String getJcTipoDeUsuario() {
		return jcTipoDeUsuario.getSelectedItem().toString();
	}

	public void limparFields() {
		fdNome.setText("");
		fdTelefone.setText("");
		setFdEmail("");
		setFdSenha("");

	}

}
