package funcionalidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import admin.Administrador;
import admin.CentralDeInformacoes;
import admin.Persistencia;
import mototaxista.Mototaxista;
import passageiro.Passageiro;
import usuario.Sexo;
import usuario.Usuario;

public class NovoUsuario {

	public static void cadastrarUsuario(int u) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();


		Usuario usuario;
		String continuar = "sim";


		while(continuar.equals("sim")) {

			try {
				System.out.println("-----> Cadastro <-----");

				String data;

				System.out.print("Insira o nome: ");
				String nome = scan.nextLine();

				System.out.print("Insira o sexo (MASCULINO/FEMININO): ");
				Sexo sexo = Sexo.valueOf(scan.nextLine().toUpperCase());

				System.out.println("Insira a data de nascimento no seguinte formato: (dia mês ano): ");
				String dia = scan.next(); 
				System.out.print(""); 
				String mes = scan.next(); 
				System.out.print("");
				String ano = scan.nextLine();
				System.out.println("");

				data = dia + "/" + mes + "/" + ano;

				Date dataNascimento = formatar.parse(data);

				System.out.print("Insira o email: ");
				String email = scan.nextLine();
				
				String senha;
				while(true) {
					
					System.out.println("Insira uma senha:");
					senha = scan.nextLine();
					System.out.println("Mais uma vez: ");
					if(senha.equals(scan.nextLine()))
						break;
					else
						System.out.println("Senhas diferentes, tente novamente!\n");
				}
				if(u == 0) 
					usuario = new Administrador(nome, sexo, dataNascimento, email, senha);
				else if(u == 1)
					usuario = new Passageiro(nome, sexo, dataNascimento, email, senha);
				else
					usuario = new Mototaxista(nome, sexo, dataNascimento, email, senha);

				central.adicionarUsuario(usuario);
				p.salvarCentral(central);

			}

			catch(ParseException c) {
				System.out.println("Digite a data corretamente");
			}
			catch(Exception t) {
				System.out.println("Passageiro não inserido");
			}

			finally {
				System.out.print("Continuar? ");
				continuar = scan.nextLine();
			}

		}

	}

}
