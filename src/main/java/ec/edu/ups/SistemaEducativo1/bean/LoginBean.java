package ec.edu.ups.SistemaEducativo1.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Docente;
import ec.edu.ups.SistemaEducativo1.model.Login;

@Named
@RequestScoped
public class LoginBean {
	
	@Inject
	private AlumnoONLocal daoAlumno;
	@Inject
	private DocenteONLocal daoDocente;
	
	/*
	 * Creacion de variables JSF
	 */
	
	private Login autenticacion = new Login();
	
	private String mensaje="";
	
	private boolean sesion = false;
	
	private String tipoSesion = "";
	
	private String cedula = "";
	
	/*
	 * Setters y Getters
	 */
	
	public Login getAutenticacion() {
		return autenticacion;
	}



	public void setAutenticacion(Login autenticacion) {
		this.autenticacion = autenticacion;
	}



	public boolean isSesion() {
		return sesion;
	}



	public void setSesion(boolean sesion) {
		this.sesion = sesion;
	}



	public String getTipoSesion() {
		return tipoSesion;
	}



	public void setTipoSesion(String tipoSesion) {
		this.tipoSesion = tipoSesion;
	}
	
	public Login getLogin() {
		return autenticacion;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public void setLogin(Login autenticacion) {
		this.autenticacion = autenticacion;
	}
	
	/*
	 * 
	 */

	public String iniciarSesion() {
		List<Docente> listaDocentes = daoDocente.listarDocente();
		List<Alumno> listaAlumnos = daoAlumno.getAlumnos();
		System.out.println(autenticacion.getPass()+" "+autenticacion.getUser());
		String respuesta="Error: no existe el correo indicado.";
		for(Alumno alumno: listaAlumnos) {
			if(!alumno.getCorreo().equals(autenticacion.getUser())) {
				respuesta="Error: no existe el correo indicado.";
			}else {
				if(!alumno.getContrasena().equals(autenticacion.getPass())) {
					respuesta="Error: la contraseña es incorrecta.";
				}else {
					respuesta="OK.";
					sesion=true;
					tipoSesion="a";
					cedula = alumno.getCedula();
					return "MenuPrincipalEstudiante?faces-redirect=true&sesion="+sesion+"&tipo="+tipoSesion+"&cedula="+cedula;
				}
			}
		}
		for(Docente docente: listaDocentes) {
			if(!docente.getCorreo().equals(autenticacion.getUser())) {
				respuesta="Error: no existe el correo indicado.";
			}else {
				if(!docente.getContrasena().equals(autenticacion.getPass())) {
					respuesta="Error: la contraseña es incorrecta.";
				}else {
					tipoSesion="d";
					sesion=true;
					respuesta="OK.";
					cedula= docente.getCedula();
					return "MenuPrincipalDocente?faces-redirect=true&sesion="+sesion+"&tipo="+tipoSesion+"&cedula="+cedula;
				}
			}
		}
		System.out.println(respuesta);
		mensaje = respuesta;
		return "login?faces-redirect=true";
	}
	
	public String cerrarSesion() {
		if(sesion) {
			sesion=false;
			tipoSesion="";
			cedula="";
			return "MenuPrincipal.xhtml";
		}else {
			System.out.println("No ha iniciado sesion");
			return "MenuPrincipal.xhtml";
		}
	}
	
	public String redicrectInfoDocente() {
		return "InformacionDocente?faces-redirect=true&cedula="+cedula;
	}
	
}
