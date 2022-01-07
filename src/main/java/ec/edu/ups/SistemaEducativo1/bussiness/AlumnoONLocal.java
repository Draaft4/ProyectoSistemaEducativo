package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Local
public interface AlumnoONLocal {
	
	public void crearAlumno(Alumno a) throws Exception;
	
}
