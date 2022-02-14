package ec.edu.ups.SistemaEducativo1.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Docente;

@Named
@RequestScoped
public class CrearUsuarioBean {

	@Inject
	private AlumnoONLocal daoAlumno;
	@Inject
	private DocenteONLocal daoDocente;

	private String mensaje = "";

	private String seleccionado = "";

	private boolean esDocente = false;

	private Docente docente = new Docente();

	private Alumno alumno = new Alumno();

	public String getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(String seleccionado) {
		this.seleccionado = seleccionado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public boolean isEsDocente() {
		return esDocente;
	}

	public void setEsDocente(boolean esDocente) {
		this.esDocente = esDocente;
	}


	public String crearAlumno() {
		try {
			daoAlumno.crearAlumno(alumno);
		} catch (Exception e) {
			mensaje = e.getMessage();
			return "MenuPrincipal?faces-redirect=true&sesion=true&tipo=a";
		}
		return "MenuPrincipal?faces-redirect=true&sesion=true&tipo=a";
	}

	public String crearDocente() {
		try {
			daoDocente.crearDocente(docente);
		} catch (Exception e) {
			mensaje = e.getMessage();
			return "MenuPrincipal?faces-redirect=true&sesion=true&tipo=a";
		}
		return "MenuPrincipal?faces-redirect=true&sesion=true&tipo=d";
	}

	public void esDocenteM(AjaxBehaviorEvent evt) {
		if (seleccionado.equals("Estudiante")) {
			esDocente = false;
		} else {
			esDocente = true;
		}
		System.out.println(esDocente);
	}

}
