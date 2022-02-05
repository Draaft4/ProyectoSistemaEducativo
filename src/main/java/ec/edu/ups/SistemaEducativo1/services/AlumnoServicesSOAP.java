package ec.edu.ups.SistemaEducativo1.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.SolicitudesONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@WebService
public class AlumnoServicesSOAP {

	@Inject
	private AlumnoONLocal dao;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private SolicitudesONLocal daoSolicitudes;

	@WebMethod
	public String crearAlumno(Alumno alumno) {
		try {
			dao.crearAlumno(alumno);
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}
	
	@WebMethod
	public List<Alumno> listarContactos() {
		return dao.getAlumnos();
	}
	
	@WebMethod
	public String agregarCalificacion(String cedulaEstudiante,int codAsignatura, int nota) {
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
	
	
	@WebMethod
	public String agregarSolicitud(String cedulaEstudiante,String contenido) {
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
