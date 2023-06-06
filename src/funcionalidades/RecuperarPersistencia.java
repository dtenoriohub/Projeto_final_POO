package funcionalidades;

import admin.CentralDeInformacoes;
import admin.Persistencia;

public abstract class RecuperarPersistencia {

	//O método verifica se o array de usuários está vazio. Se sim, não há adm 
	//cadastrado.
	public static boolean verificarExitenciaAdmin() {
		
		Persistencia p = new Persistencia();
		CentralDeInformacoes c = p.recuperarCentral();
		
		return(c.getTodosOsUsuarios().size() == 0);
	}
	
	
	
}
