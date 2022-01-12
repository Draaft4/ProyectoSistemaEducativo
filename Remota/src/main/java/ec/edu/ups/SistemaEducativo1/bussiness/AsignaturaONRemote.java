package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Remote;

import ec.edu.ups.SistemaEducativo1.model.Asignatura;

@Remote
public interface AsignaturaONRemote {
	
	public void crearAsignatura(Asignatura a) throws Exception;
	
	public Asignatura obtenerAsignatura(int codigo) throws Exception;
	
}
