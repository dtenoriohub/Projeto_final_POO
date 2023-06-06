package passageiro;

import java.util.ArrayList;
import java.util.Scanner;

import admin.CentralDeInformacoes;
import admin.Persistencia;

public class ListarCorridasDeUmPassageiro {

	public static void listarCorridasDeUmPassageiro() {
		Scanner scan = new Scanner(System.in);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		System.out.print("Identificador do passageiro: "); String identificador = scan.nextLine();
		
		ArrayList<Corrida> corridas = central.recuperarCorridasDeUmPassageiro(identificador);
		central.imprimirCorridasDeUmPassageiro(corridas);
	}
	
}
