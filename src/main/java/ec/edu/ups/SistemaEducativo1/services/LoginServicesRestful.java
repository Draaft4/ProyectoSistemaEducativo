package ec.edu.ups.SistemaEducativo1.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Docente;
import ec.edu.ups.SistemaEducativo1.model.Login;

import java.util.List;

@Path("login")
public class LoginServicesRestful {
	
	@Inject
	private AlumnoONLocal daoAlumno;
	@Inject
	private DocenteONLocal daoDocente;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String login(Login login) {
		List<Docente> listaDocentes = daoDocente.listarDocente();
		List<Alumno> listaAlumnos = daoAlumno.getAlumnos();
		System.out.println(login.getPass()+" "+login.getUser());
		String respuesta="{\"response\":\"Error: no existe el correo indicado.\"}";
		for(Alumno alumno: listaAlumnos) {
			if(!alumno.getCorreo().equals(login.getUser())) {
				respuesta="{\"response\":\"Error: no existe el correo indicado.\"}";
			}else {
				if(!alumno.getContraseña().equals(login.getPass())) {
					respuesta="{\"response\":\"Error: la contraseña es incorrecta.\"}";
				}else {
					respuesta="{\"response\":\"OK.\"}";
				}
			}
		}
		for(Docente docente: listaDocentes) {
			if(!docente.getCorreo().equals(login.getUser())) {
				respuesta="{\"response\":\"Error: la contraseña es incorrecta.\"}";
			}else {
				if(!docente.getContraseña().equals(login.getPass())) {
					respuesta="{\"response\":\"Error: la contraseña es incorrecta.\"}";
				}else {
					respuesta="{\"response\":\"OK.\"}";
				}
			}
		}
		System.out.println(respuesta);
		return respuesta;
	}
	
}
