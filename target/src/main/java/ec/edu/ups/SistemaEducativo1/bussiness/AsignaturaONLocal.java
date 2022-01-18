package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Asignatura;
@Local
public interface AsignaturaONLocal {
	
	public void crearAsignatura(Asignatura a) throws Exception;
	public Asignatura obtenerAsignatura(int codigo) throws Exception;
	
}
