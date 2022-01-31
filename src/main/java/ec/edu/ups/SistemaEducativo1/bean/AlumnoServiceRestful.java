package ec.edu.ups.SistemaEducativo1.bean;

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
import ec.edu.ups.SistemaEducativo1.bussiness.SolicitudesONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Path("alumno")
public class AlumnoServiceRestful {

	@Inject
	private AlumnoONLocal dao;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private SolicitudesONLocal daoSolicitudes;

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
	public List<Alumno> listarContactos() {
		return dao.getAlumnos();
	}

	@PUT
	@Path("calificaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public String agregarCalificacion(@QueryParam("cedula") String cedulaEstudiante,
			@QueryParam("asignatura") int codAsignatura, @QueryParam("calificacion") int nota) {
		Calificaciones calificacion = new Calificaciones();
		Alumno alumno = dao.obtenerAlumno(cedulaEstudiante);
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
				dao.actualiarAlumno(alumno);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "";
		} else {
			return "No se ha encontrado el alumno";
		}
	}

	@PUT
	@Path("solicitudes")
	@Produces(MediaType.APPLICATION_JSON)
	public String agregarSolicitud(@QueryParam("cedula") String cedulaEstudiante,
			@QueryParam("contenido") String contenido) {

		Alumno alumno = dao.obtenerAlumno(cedulaEstudiante);
		if (alumno != null) {
			Solicitudes solicitud = new Solicitudes();
			solicitud.setContenido(contenido);
			try {
				daoSolicitudes.crearSolicitud(solicitud);
			} catch (Exception e) {
			}
			if (alumno.getSolicitudes() != null) {
				alumno.getSolicitudes().add(solicitud);
			} else {
				alumno.setSolicitudes(new ArrayList<Solicitudes>());
				alumno.getSolicitudes().add(solicitud);
			}
			try {
				dao.actualiarAlumno(alumno);
			} catch (Exception e) {
				return e.getMessage();
			}
			return "";
		} else {
			return "No se ha encontrado el alumno";
		}
	}

}
