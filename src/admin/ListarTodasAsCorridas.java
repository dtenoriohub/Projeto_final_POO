package admin;

import java.util.ArrayList;

import passageiro.Corrida;
import usuario.Usuario;

public class ListarTodasAsCorridas {

	public static void listarTodasAsCorridas() {
		
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		System.out.println("----- Listagem de todas as corridas na central -----");
		
		try {
			
			for(Usuario passageiro : central.getTodosOsUsuarios()) {
				System.out.println("Corridas de " + passageiro.getNome());
				
				ArrayList<Corrida> corridas = central.recuperarCorridasDeUmPassageiro(passageiro.getEmail());
				central.imprimirCorridasDeUmPassageiro(corridas);
				
				}
		}
		
		catch(Exception e) {
			System.out.println("A central de corridas está vazia!");
		}
		
	}
}
