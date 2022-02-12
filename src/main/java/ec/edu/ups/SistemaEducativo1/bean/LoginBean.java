package ec.edu.ups.SistemaEducativo1.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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
	
	public String login(String user, String pass) {
		Login login = new Login();
		login.setPass(pass);login.setUser(user);
		List<Docente> listaDocentes = daoDocente.listarDocente();
		List<Alumno> listaAlumnos = daoAlumno.getAlumnos();
		System.out.println(login.getPass()+" "+login.getUser());
		String respuesta="Error: no existe el correo indicado.";
		for(Alumno alumno: listaAlumnos) {
			if(!alumno.getCorreo().equals(login.getUser())) {
				respuesta="Error: no existe el correo indicado.";
			}else {
				if(!alumno.getContrasena().equals(login.getPass())) {
					respuesta="Error: la contraseña es incorrecta.";
				}else {
					respuesta="OK.";
				}
			}
		}
		for(Docente docente: listaDocentes) {
			if(!docente.getCorreo().equals(login.getUser())) {
				respuesta="Error: no existe el correo indicado.";
			}else {
				if(!docente.getContrasena().equals(login.getPass())) {
					respuesta="Error: la contraseña es incorrecta.";
				}else {
					respuesta="OK.";
				}
			}
		}
		System.out.println(respuesta);
		return respuesta;
	}
	
}
