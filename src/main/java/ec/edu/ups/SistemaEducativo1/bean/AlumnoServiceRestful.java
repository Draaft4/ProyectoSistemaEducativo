package ec.edu.ups.SistemaEducativo1.bean;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Path("alumno")
public class AlumnoServiceRestful {
	
	@Inject
	private AlumnoONLocal dao;
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String crearAlumno(Alumno alumno) {
		try {
			dao.crearAlumno(alumno);
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> listarContactos(){
		return dao.getAlumnos();
	}
	
}
