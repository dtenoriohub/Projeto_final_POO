package admin;

import usuario.Usuario;

public class ListarTodosOsPassageiros {

	public static void listarTodosOsPassageiros() {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		if (central.getTodosOsUsuarios().size() == 0)
			System.out.println("Não há passageiros cadastrados !");
		else {
			System.out.println("Passageiros: ");
			for (Usuario passageiro : central.getTodosOsUsuarios()) {
				System.out.println(passageiro.toString());
				
				
			}
		}
	}
}
