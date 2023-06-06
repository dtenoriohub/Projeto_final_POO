package funcionalidades;

import java.util.Scanner;

import admin.CentralDeInformacoes;
import admin.GeradorDeRelatorios;
import admin.GerarRelatorioDeCorrida;
import admin.ListarTodasAsCorridas;
import admin.ListarTodosOsPassageiros;
import admin.Mensageiro;
import admin.Persistencia;
import passageiro.BuscarPassageiroEspecifico;
import passageiro.ListarCorridasDeUmPassageiro;
import passageiro.NovaCorrida;
import passageiro.Passageiro;
import usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String opcao = "";

		while (!opcao.equals("s")) {
			System.out.print(""
					+ "1 - Novo passageiro \n" 
					+ "2 - Listar todos os passageiros \n"
					+ "3 - Exibir informações de um passageiro específico \n"
					+ "4 - Nova corrida \n"
					+ "5 - Listar todas as corridas \n" 
					+ "6 - Listar corridas de um passageiro \n"
					+ "7 - Gerar relatório de solicitação de corridas\n" 
					+ "8 - Enviar Histórico de corridas\n"
					+ "S - sair \n" 
					+ "Opção: ");
			
			opcao = scan.nextLine();

			if (opcao.equals("1"))
				NovoUsuario.cadastrarUsuario(1);
			else if (opcao.equals("2"))
				ListarTodosOsPassageiros.listarTodosOsPassageiros();
			else if (opcao.equals("3"))
				BuscarPassageiroEspecifico.buscarPassageiroEspecifico();
			else if (opcao.equals("4"))
				NovaCorrida.novaCorrida();
			else if (opcao.equals("5"))
				ListarTodasAsCorridas.listarTodasAsCorridas();
			else if (opcao.equals("6"))
				ListarCorridasDeUmPassageiro.listarCorridasDeUmPassageiro();
			else if (opcao.equals("7"))
				GerarRelatorioDeCorrida.gerarRelatorioDeCorrida();
			else if(opcao.equals("8")) {
				
				Persistencia p = new Persistencia();
				CentralDeInformacoes central =  p.recuperarCentral();
				System.out.print("Email do passageiro para envio de relatório: ");
				String email = scan.nextLine();
				
				Passageiro pas = (Passageiro) central.recuperarUsuarioPeloEmail(email);
				if(pas != null) {
					
					GeradorDeRelatorios.obterSolicitacaoDeCorrida(pas);
					Mensageiro novaMensagem = new Mensageiro();
					novaMensagem.enviarHistóricoDeCorrida(pas);
					
				}	
				else
					System.out.println("Passageiro não encontrado");
				
			}
			System.out.println("---------------");
		}
	
scan.close();
	}
}
