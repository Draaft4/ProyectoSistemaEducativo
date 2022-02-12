package ec.edu.ups.SistemaEducativo1.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;


@WebService
public class DocenteServiceSOAP {
	
	
	@Inject
	private DocenteONLocal dao;
	@Inject
	private AlumnoONLocal daoEstudiantes;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private AsignaturaONLocal daoAsignatura;
	
	@WebMethod
	public String crearDocente(Docente docente) {
		try {
			dao.crearDocente(docente);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "";
	}
	
	@WebMethod
	public List<Docente> listarDocentes() {
		return dao.listarDocente();
	}
	
	@WebMethod
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
	
	
	@WebMethod
	public Docente obtenerDocente(String cedula) {
		return dao.getDocente(cedula);
	}
	
	@WebMethod
	public String crearAsignatura(Asignatura asignatura){
		try {
			daoAsignatura.crearAsignatura(asignatura);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "e";
	}
	
}
