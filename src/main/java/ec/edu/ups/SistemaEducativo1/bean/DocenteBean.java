package ec.edu.ups.SistemaEducativo1.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;

@Named
@RequestScoped
public class DocenteBean {

	@Inject
	private DocenteONLocal dao;
	@Inject
	private AlumnoONLocal daoEstudiantes;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private AsignaturaONLocal daoAsignatura;
	
	public String crearDocente(Docente docente) {
		try {
			dao.crearDocente(docente);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "";
	}
	
	public List<Docente> listarDocentes() {
		return dao.listarDocente();
	}
	
	public String agregarCalificacion(String cedulaEstudiante,int codAsignatura, int nota) {
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
	
	public Docente obtenerDocente(String cedula) {
		return dao.getDocente(cedula);
	}
	
	public String crearAsignatura(Asignatura asignatura){
		try {
			daoAsignatura.crearAsignatura(asignatura);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "e";
	}
	
	
}
