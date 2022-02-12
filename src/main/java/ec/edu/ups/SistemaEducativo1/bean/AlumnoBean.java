package ec.edu.ups.SistemaEducativo1.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.SolicitudesONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Named
@RequestScoped
public class AlumnoBean {

	@Inject
	private AlumnoONLocal dao;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private SolicitudesONLocal daoSolicitudes;
	@Inject
	private AsignaturaONLocal daoAsignaturas;

	public String crearAlumno(Alumno alumno) {
		try {
			dao.crearAlumno(alumno);
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}
	
	public List<Alumno> listarContactos() {
		return dao.getAlumnos();
	}
	
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
	
	public Alumno obtenerAlumno(String cedula) {
		return dao.obtenerAlumno(cedula);
	}
	
	public List<Asignatura> getListaAsignaturas(){
		return daoAsignaturas.getList();
	}
	
	public String actualizarAlumno(Alumno asg) {
		
		 try {
			dao.actualiarAlumno(asg);
		} catch (Exception e) {
			return e.getMessage();
		}
		 return "";
	}
	
}
