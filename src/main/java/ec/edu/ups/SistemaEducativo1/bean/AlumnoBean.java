package ec.edu.ups.SistemaEducativo1.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Named
@RequestScoped
public class AlumnoBean {

	@Inject
	private AlumnoONLocal alumnoON;
	
	private int codigoEstudiante;
	
	private Alumno alumno  = new Alumno();
	
	private List<Alumno> alumnos;
	
	private AlumnoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}

	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(int codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public void loadData() {
		if(codigoEstudiante==0)
			return;
		
		Alumno alu;
		try {
			alu = alumnoON.obtenerAlumno(codigoEstudiante);
			alumno = alu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		
	}
	
	public void loadDataEditar() {
		Alumno alu;
		try {
			alu = alumnoON.obtenerAlumno(alumno.getId());
			alumno = alu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public String guardar() {
		
		System.out.println("Guaradndo " + this.alumno.getDatos().getNombre());
	
		
		try {
			alumnoON.crearAlumno(this.alumno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Alumno?faces-redirect=true"; //
	}
	
	public String editar(int codigo){
		System.out.println(codigo);
		return "persona?faces-redirect=true&id="+codigo;
	}

	public void loadAlumnos() {
		this.alumnos = alumnoON.getAlumnos();
	}
	
	
	
	
	
	
	
}
