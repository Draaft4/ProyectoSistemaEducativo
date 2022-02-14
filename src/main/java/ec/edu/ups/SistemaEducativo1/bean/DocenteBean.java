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
import ec.edu.ups.SistemaEducativo1.bussiness.SolicitudesONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

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
	@Inject
	private SolicitudesONLocal daoSolicitudes;

	/*
	 * Creacion variables de JSF
	 */

	private Docente docente = new Docente();

	private List<Docente> lista = new ArrayList<Docente>();

	private String mensaje = "";

	private Asignatura asignatura = new Asignatura();

	private String cedEstudiante = "";

	private int codAsignatura = 0;

	private int nota = 0;
	
	private List<Solicitudes> list = new ArrayList<Solicitudes>();
	

	/*
	 * Setters y Getters
	 */

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public List<Solicitudes> getList() {
		return list;
	}

	public void setList(List<Solicitudes> list) {
		this.list = list;
	}

	public String getCedEstudiante() {
		return cedEstudiante;
	}

	public void setCedEstudiante(String cedEstudiante) {
		this.cedEstudiante = cedEstudiante;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Docente> getLista() {
		return lista;
	}

	public void setLista(List<Docente> lista) {
		this.lista = lista;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/*
	 * 
	 */

	public void crearDocente() {
		try {
			dao.crearDocente(docente);
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
	}

	public void listarDocentes() {
		lista = dao.listarDocente();
	}

	public void agregarCalificacion() {
		Calificaciones calificacion = new Calificaciones();
		Alumno alumno = daoEstudiantes.obtenerAlumno(cedEstudiante);
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
				mensaje = e.getMessage();
			}
		} else {
			mensaje = "No se ha encontrado el alumno";
		}
	}

	public void obtenerDocente() {
		docente = dao.getDocente(docente.getCedula());
	}

	public void crearAsignatura() {
		try {
			daoAsignatura.crearAsignatura(asignatura);
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
	}
	
	public String buscarPorCedula() {
		return "InformacionDocente?faces-redirect=true&cedula="+docente.getCedula();
	}
	
	public String menu() {
		return "MenuPrincipal?faces-redicrect=true";
	}
	
	public void cargarsolicitudes() {
		List<Solicitudes> a = daoSolicitudes.lista();
		for(Solicitudes s: a) {
			if(s.getDestinatario().getCedula().equals(docente.getCedula())){
				list.add(s);
			}
		}
		System.out.println(list.size());
		
	}

}
