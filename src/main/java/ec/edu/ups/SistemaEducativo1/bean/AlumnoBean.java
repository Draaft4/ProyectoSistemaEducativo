package ec.edu.ups.SistemaEducativo1.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
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
public class AlumnoBean {

	@Inject
	private AlumnoONLocal dao;
	@Inject
	private CalificacionesONLocal daoCalifiaciones;
	@Inject
	private SolicitudesONLocal daoSolicitudes;
	@Inject
	private AsignaturaONLocal daoAsignaturas;

	@Inject
	private DocenteONLocal daoDocente;

	/*
	 * Declaracion de Variables de JSF
	 */

	private String mensaje = "";

	private Alumno alumno = new Alumno();

	private List<Alumno> lista = new ArrayList<Alumno>();

	private List<String> nombresAsg = new ArrayList<String>();

	private List<Asignatura> listAsignatura = new ArrayList<Asignatura>();

	private List<Calificaciones> cali = new ArrayList<Calificaciones>();

	private Docente destinatario = new Docente();

	private int nota = 0;

	private int codAsignatura = 0;

	private String contenido = "";

	private String selecionado = "";
	
	private Date fechaInscripcion = new Date();

	/*
	 * Setters y Getters
	 */

	public String getMensaje() {
		return mensaje;
	}

	public Docente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Docente destinatario) {
		this.destinatario = destinatario;
	}

	public String getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Alumno> getLista() {
		return lista;
	}

	public void setLista(List<Alumno> lista) {
		this.lista = lista;
	}

	public List<Asignatura> getListAsignatura() {
		return listAsignatura;
	}

	public void setListaAsignatura(List<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;

	}

	public List<String> getNombresAsg() {
		return nombresAsg;
	}

	public void setNombresAsg(List<String> nombresAsg) {
		this.nombresAsg = nombresAsg;
	}

	public List<Calificaciones> getCali() {
		return cali;
	}

	public void setCali(List<Calificaciones> cali) {
		this.cali = cali;
	}

	public void setListAsignatura(List<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}

	/*
	 * 
	 */

	public String crearAlumno() {
		try {
			dao.crearAlumno(alumno);
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}

	public void listarContactos() {
		lista = dao.getAlumnos();
	}

	public String agregarCalificacion() {
		if (codAsignatura != 0) {
			Calificaciones calificacion = new Calificaciones();
			Alumno alumno1 = dao.obtenerAlumno(alumno.getCedula());
			if (alumno1 != null) {
				calificacion.setNotaParcial(nota);
				try {
					daoCalifiaciones.insertarCalificaciones(calificacion);
				} catch (Exception e1) {
				}

				for (Asignatura asignatura : alumno1.getAsignaturas()) {
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
					dao.actualiarAlumno(alumno1);
				} catch (Exception e) {
					mensaje = e.getMessage();
				}
				return "MenuPrincipal?faces-redirect=true";
			} else {
				mensaje = "No se ha encontrado el alumno";
			}
			return "";
		} else {
			return "";
		}
	}

	public String agregarSolicitud() {
		Alumno alumno1 = dao.obtenerAlumno(alumno.getCedula());
		if (alumno1 != null) {
			destinatario = daoDocente.getDocente(destinatario.getCedula());
			if (destinatario != null) {
				Solicitudes solicitud = new Solicitudes();
				solicitud.setContenido(contenido);
				solicitud.setDestinatario(destinatario);
				try {
					daoSolicitudes.crearSolicitud(solicitud);
				} catch (Exception e) {
				}
				if (alumno1.getSolicitudes() != null) {
					alumno1.getSolicitudes().add(solicitud);
				} else {
					alumno1.setSolicitudes(new ArrayList<Solicitudes>());
					alumno1.getSolicitudes().add(solicitud);
				}
				try {
					dao.actualiarAlumno(alumno1);
				} catch (Exception e) {
					mensaje = e.getMessage();
				}
				return "MenuPrincipal?faces-redirect=true";
			}
		} else {
			mensaje = "No se ha encontrado el alumno";
		}
		return "";
	}

	public void obtenerAlumno() {
		alumno = dao.obtenerAlumno(alumno.getCedula());
		if(alumno!=null) {
			System.out.println(alumno.toString());
			getListaAsignaturas();
			getAsignaturasPersona();
			getCalificcionesPersona();
		}
	}

	public void getListaAsignaturas() {
		listAsignatura = daoAsignaturas.getList();
	}

	public void getAsignaturasPersona() {
		System.out.println(alumno.getCedula());
		listAsignatura = alumno.getAsignaturas();
		for (Asignatura as : listAsignatura) {
			nombresAsg.add(as.getNombreAsignatura());
		}
	}

	public void seleccionadoP() {
		for (Asignatura asg : listAsignatura) {
			if (asg.getCodigo() == codAsignatura)
				selecionado = asg.getNombreAsignatura();
		}
	}


	public void getCalificcionesPersona() {
		for (Asignatura asg : listAsignatura) {
			if (asg.getCodigo() == codAsignatura) {
				System.out.println("Encontro");
				cali = asg.getCalificaciones();
				if(cali!=null) {
					for (Calificaciones c : cali) {
						nota += c.getNotaParcial();
					}
				}
				break;
			}
		}
	}
	
	public void matricular() {
		Asignatura as =null;
		alumno = dao.obtenerAlumno(alumno.getCedula());
		try {
			 as = daoAsignaturas.obtenerAsignatura(codAsignatura);
		} catch (Exception e) {
		}
		if(as!=null) {
			alumno.getAsignaturas().add(as);
			alumno.setFechaInscripcion(fechaInscripcion);
			try {
				dao.actualiarAlumno(alumno);
			} catch (Exception e) {
			}
			obtenerAlumno();
		}
	}

}
