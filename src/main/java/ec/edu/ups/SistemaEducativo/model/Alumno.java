package ec.edu.ups.SistemaEducativo.model;

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
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Alumno")
public class Alumno extends Persona {
	
	@Column(name = "alu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "alu_fechaInscripcion")
	private Date fechaInscripcion;
	
	
	@Column(name = "alu_solicitudes")
	@OneToMany
	@JoinColumn(name = "soli_id")
	private  ArrayList<Solicitudes> solicitudes;
	
	@Column(name = "alu_asignatura")
	@OneToMany
	@JoinColumn(name = "asig_codigo")
	private ArrayList<Asignatura> asignaturas;
	
	@Column(name = "alu_horario")
	private ArrayList<String> horario;

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
	
	

	

	
	
	
	
	
}
