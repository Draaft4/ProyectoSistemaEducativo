package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Alumno")
public class Alumno extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "alu_fechaInscripcion")
	private Date fechaInscripcion;
	
	
	@JoinColumn(name = "soli_id")
	private  ArrayList<Solicitudes> solicitudes;
	
	@JoinColumn(name = "asig_codigo")
	private ArrayList<Asignatura> asignaturas;
	
	@Column(name = "alu_horario")
	private ArrayList<String> horario;

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

	@Override
	public String toString() {
		return this.toS()+"Alumno  fechaInscripcion=" + fechaInscripcion + ", solicitudes=" + solicitudes
				+ ", asignaturas=" + asignaturas + ", horario=" + horario + "]";
	}
	
	

	

	
	
	
	
	
}
