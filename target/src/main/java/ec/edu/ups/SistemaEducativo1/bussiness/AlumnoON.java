package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.AlumnoDAO;
import ec.edu.ups.SistemaEducativo1.dao.PersonaDAO;
import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Stateless
public class AlumnoON implements AlumnoONLocal,AlumnoONRemote{
	
	@Inject
	private AlumnoDAO dao;
	@Inject
	private PersonaDAO dao2;
	
	public void crearAlumno(Alumno a) throws Exception {
		dao2.insert(a.getDatos());
		dao.insert(a);
	}
	
	public Alumno obtenerAlumno(int id) throws Exception{
		return dao.read(id);
	}
	
	public List<Alumno> getAlumnos(){
		return dao.getList();
	}
	 
}
