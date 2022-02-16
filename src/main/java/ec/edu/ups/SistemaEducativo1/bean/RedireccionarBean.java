package ec.edu.ups.SistemaEducativo1.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RedireccionarBean {
	
	public String redCrearDocente() {
		return "crear_docente?faces-redirect=true";
	}
	
	public String redCrearAlumno() {
		return "crear_usuario?faces-redirect=true";
	}
	
	public String redEscojerTipo() {
		return "EscojerTipoUsuario?faces-redirect=true";
	}
	
	public String redInformacionDocente() {
		return "InformacionDocente?faces-redirect=true&cedula=0";
	}
	
	public String redInformacionEstudiante() {
		return "InformacionUsuario?faces-redirect=true&cedula=0";
	}
	
	public String redIngresarCalificaciones() {
		return "IngresarCalificaciones?faces-redirect=true";
	}
	
	public String redListarCalificaciones() {
		return "ListarCalificaciones?faces-redirect=true";
	}
	
	public String redLogin() {
		return "login?faces-redirect=true";
	}
	
	public String redMatricula() {
		return "matricula?faces-redirect=true";
	}
	
	public String redMenuPrincipalG() {
		return "MenuPrincipal?faces-redirect=true";
	}
	
	public String redMenuPrincipalDocente() {
		return "MenuPrincipalDocente?faces-redirect=true&tipo=d&sesion=true";
	}
	
	public String redMenuPrincipalEstudiante() {
		return "MenuPrincipalEstudiante?faces-redirect=true&tipo=a&sesion=true";
	}
	
	public String redRegistroAsignatura() {
		return "RegistroAsignatura?faces-redirect=true";
	}
	
	public String redSolicitudes() {
		return "Solicitudes?faces-redirect=true";
	}
	
	public String redVerSolicitudes() {
		return "VerSolicitudes?faces-redirect=true";
	}
	
}
