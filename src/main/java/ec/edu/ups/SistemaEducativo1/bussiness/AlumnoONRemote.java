package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Remote
public interface AlumnoONRemote {
	
public void crearAlumno(Alumno a) throws Exception;
	
	public Alumno obtenerAlumno(String id);
	
	public List<Alumno> getAlumnos();
	
	public void actualiarAlumno(Alumno a) throws Exception;
	
	
}
