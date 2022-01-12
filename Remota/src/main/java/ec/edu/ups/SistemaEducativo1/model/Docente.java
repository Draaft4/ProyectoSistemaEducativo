package ec.edu.ups.SistemaEducativo1.model;

import java.util.ArrayList;
import java.util.List;
public class Docente extends Persona {

	private int id;
	
	
	private String tituloAcademico;
	
	
	private ArrayList<String> horario;
	
	
	
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
