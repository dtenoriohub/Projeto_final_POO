package passageiro;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import admin.CentralDeInformacoes;
import admin.Persistencia;

public class BuscarPassageiroEspecifico {

	public static void buscarPassageiroEspecifico() {
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scan = new Scanner(System.in);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		
		System.out.print("Insira o email do passageiro: "); String email = scan.nextLine();
		Passageiro passageiro = (Passageiro) central.recuperarUsuarioPeloEmail(email);
		
		try {
			System.out.println("\nNome: " + passageiro.getNome());
			System.out.println("Sexo: " + passageiro.getSexo());
			System.out.println("Data de nascimento: " + formatar.format(passageiro.getDataNascimento()));
			System.out.println("Email: " + email);
			
		}
			
		catch(Exception e) {
			System.out.println("Passageiro não encontrado");
		}
	}
}
