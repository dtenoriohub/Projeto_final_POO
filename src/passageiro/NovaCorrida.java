package passageiro;

import java.util.Scanner;

import admin.CentralDeInformacoes;
import admin.Persistencia;

public class NovaCorrida {

	public static void novaCorrida() {
		Scanner scan = new Scanner(System.in);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		System.out.print("Insira o seu identificador: ");
		String identificador = scan.nextLine();
		Passageiro passageiro = (Passageiro) central.recuperarUsuarioPeloEmail(identificador);

		if(passageiro == null)
			System.out.println("Este passageiro nao possui cadastro !");
		
		else {
			
			System.out.print("Insira o endereço de partida: ");
			String enderecoPartida = scan.nextLine();
			
			System.out.println("Insira o endereço de destino: ");
			String enderecoDestino = scan.nextLine();
			
			Corrida novaCorrida = new Corrida(enderecoPartida, enderecoDestino, passageiro);
			
			if(central.adicionarCorrida(novaCorrida)) {
				
				System.out.println("Corrida adicionada, seu ID: " + novaCorrida.getId());
				p.salvarCentral(central);
			}
				else
				System.out.println("Corrida não efetuada.");
		}
		
		
	}
}
