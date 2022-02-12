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
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.SolicitudesONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Path("alumno")
public class AlumnoServiceRestful {

	@Inject
	private AlumnoONLocal dao;
	@Inject
	private SolicitudesONLocal daoSolicitudes;

	@Inject
	private AsignaturaONLocal daoAsignaturas;


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
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public Alumno getAlumno(@QueryParam("usuario")String usuario) {
		List<Alumno> listaA = dao.getAlumnos();
		for(Alumno alumno: listaA) {
			if(alumno.getCorreo().equals(usuario)) {
				return alumno;
			}
		}
		return new Alumno();
	}
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> listarAlumnos() {
		return dao.getAlumnos();
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Alumno obtenerAlumno(@QueryParam("cedula")String cedula) {
		return dao.obtenerAlumno(cedula);
	}
	
	@GET
	@Path("asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Asignatura> getListaAsignaturas(){
		return daoAsignaturas.getList();
	}

	@PUT
	@Path("asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String actualizarAlumno(Alumno asg) {
		 try {
			dao.actualiarAlumno(asg);
		} catch (Exception e) {
			return e.getMessage();
		}
		 return "";
	}

}
