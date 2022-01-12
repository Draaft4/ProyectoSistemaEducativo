package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
public class Alumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	
	private Date fechaInscripcion;
	
	
	private  ArrayList<Solicitudes> solicitudes;

	private ArrayList<Asignatura> asignaturas;
	
	
	private ArrayList<String> horario;
	
	private Persona datos;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public ArrayList<Solicitudes> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitudes> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public ArrayList<String> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<String> horario) {
		this.horario = horario;
	}
	public Persona getDatos() {
		return datos;
	}

	public void setDatos(Persona datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return datos.toS()+"Alumno [id=" + id + ", fechaInscripcion=" + fechaInscripcion + ", solicitudes=" + solicitudes
				+ ", asignaturas=" + asignaturas + ", horario=" + horario + "]";
	}
	
	

	

	
	
	
	
	
}
