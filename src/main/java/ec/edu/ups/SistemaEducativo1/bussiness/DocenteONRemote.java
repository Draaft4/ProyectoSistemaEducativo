package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.SistemaEducativo1.model.Docente;

@Remote
public interface DocenteONRemote {
	
	public void crearDocente(Docente d) throws Exception;
	
	public List<Docente> listarDocente();
	
}
