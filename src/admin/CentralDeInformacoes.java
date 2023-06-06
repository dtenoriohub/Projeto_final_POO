package admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import passageiro.Corrida;
import passageiro.Passageiro;
import usuario.Usuario;

public class CentralDeInformacoes {

	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<>();
	private ArrayList<Corrida> corridas = new ArrayList<>();
	//private Administrador adm = (Administrador) todosOsUsuarios.get(0);
	
	
	public boolean adicionarUsuario(Usuario p) {
		
		boolean flag = false;		
		if(recuperarUsuarioPeloEmail(p.getEmail()) == null) {
			todosOsUsuarios.add(p);
			flag = true;
		}	
		return flag;	
	}
	
	public Usuario recuperarUsuarioPeloEmail(String email) {
		
		for(Usuario p: todosOsUsuarios) {
			if(p.getEmail().equals(email))
				return p;
		}
		return null;
		
	}
	public void atualizarSenhaUsuario(String email, String senha) {
		Usuario u = recuperarUsuarioPeloEmail(email);
		u.setSenha(senha);
	}
	
	public ArrayList<Usuario> getTodosOsUsuarios(){
		return todosOsUsuarios;
	}
	
	public void setTodosOsPassageiros(ArrayList<Usuario> passageiros) {
		todosOsUsuarios = passageiros;
	}
	
	public boolean adicionarCorrida(Corrida novaCorrida) {
		boolean flag = false;
		for(Corrida corrida : corridas) {
			if(novaCorrida.getId() == corrida.getId())
				return flag;
		}
		corridas.add(novaCorrida);
		return !flag;
	}
	public Corrida recuperarCorridaPeloId(long id) {
		
		for(Corrida corrida : corridas) {
			if(id == corrida.getId())
				return corrida;
		}
		return null;
	}
	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String identificador){
		
		ArrayList<Corrida> flag = new ArrayList<>();
		
		if(recuperarUsuarioPeloEmail(identificador) == null)
			flag = null;
		else {
			for(Corrida corrida : corridas) {
				if(corrida.getRequerente().getEmail().equals(identificador))
					flag.add(corrida);
			}
			return flag;
		}
		return flag;
	}
	public void imprimirCorridasDeUmPassageiro(ArrayList<Corrida> corridas) {
		for(Corrida corrida : corridas) {
			System.out.println(
					"Corrida(ID): " + corrida.getId() 
					+ "\nHorário: " + new SimpleDateFormat("HH:mm:ss").format(corrida.getDadosSolicitacao())
					+ "\nData: " + new SimpleDateFormat("dd/MM/yyyy").format(corrida.getDadosSolicitacao()));
		}
	}
	public ArrayList<Corrida> getCorridas(){
		return corridas;
	}

	
}
