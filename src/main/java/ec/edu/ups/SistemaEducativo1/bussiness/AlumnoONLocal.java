package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Local
public interface AlumnoONLocal {
	
	public void crearAlumno(Alumno a) throws Exception;
	
	public Alumno obtenerAlumno(String id) throws Exception;
	
	public List<Alumno> getAlumnos();
	
}
