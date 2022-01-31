package ec.edu.ups.SistemaEducativo1.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
@Entity
public class Docente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "doc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "doc_tituloAcademico")
	private String tituloAcademico;
	
	@Column(name = "doc_horario")
	private ArrayList<String> horario;
	
	
	@JoinColumn(name = "soli_id")
	private ArrayList<Solicitudes> solicitudes;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTituloAcademico() {
		return tituloAcademico;
	}


	public void setTituloAcademico(String tituloAcademico) {
		this.tituloAcademico = tituloAcademico;
	}


	public ArrayList<String> getHorario() {
		return horario;
	}


	public void setHorario(ArrayList<String> horario) {
		this.horario = horario;
	}


	public ArrayList<Solicitudes> getSolicitudes() {
		return solicitudes;
	}


	public void setSolicitudes(ArrayList<Solicitudes> solicitudes) {
		this.solicitudes = solicitudes;
	}
	


	
	

	
	
	
	
}
