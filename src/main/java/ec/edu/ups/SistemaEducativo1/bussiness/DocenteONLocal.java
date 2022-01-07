package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Docente;

@Local
public interface DocenteONLocal {
	
	public void crearDocente(Docente d) throws Exception;
	
}
