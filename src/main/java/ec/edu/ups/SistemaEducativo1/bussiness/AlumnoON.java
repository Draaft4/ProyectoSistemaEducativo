package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.AlumnoDAO;
import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Stateless
public class AlumnoON implements AlumnoONLocal,AlumnoONRemote{
	
	@Inject
	private AlumnoDAO dao;
	
	public void crearAlumno(Alumno a) throws Exception {
		dao.insert(a);
	}
	
	public Alumno obtenerAlumno(String id) throws Exception{
		return dao.read(id);
	}
	
	public List<Alumno> getAlumnos(){
		return dao.getList();
	}
	 
}
