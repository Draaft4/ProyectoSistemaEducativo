package ec.edu.ups.SistemaEducativo1.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;

@Path("docente")
public class DocenteServiceRestful {
	
	@Inject
	private DocenteONLocal dao;
	@Inject
	private AlumnoONLocal daoEstudiantes;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String crearDocente(Docente docente) {
		try {
			dao.crearDocente(docente);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Docente> listarDocentes() {
		return dao.listarDocente();
	}
	
	@PUT
	@Path("calificaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public String agregarCalificacion(@QueryParam("cedula") String cedulaEstudiante,
			@QueryParam("asignatura") int codAsignatura, @QueryParam("calificacion") int nota) {
		Calificaciones calificacion = new Calificaciones();
		Alumno alumno = daoEstudiantes.obtenerAlumno(cedulaEstudiante);
		if (alumno != null) {
			calificacion.setNotaParcial(nota);
			try {
				daoCalifiaciones.insertarCalificaciones(calificacion);
			} catch (Exception e1) {
			}

			for (Asignatura asignatura : alumno.getAsignaturas()) {
				if (asignatura.getCodigo() == codAsignatura) {
					if (asignatura.getCalificaciones() != null) {
						asignatura.getCalificaciones().add(calificacion);
					} else {
						asignatura.setCalificaciones(new ArrayList<Calificaciones>());
						asignatura.getCalificaciones().add(calificacion);
					}
				}
			}
			try {
				daoEstudiantes.actualiarAlumno(alumno);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "";
		} else {
			return "No se ha encontrado el alumno";
		}
	}
	
}
