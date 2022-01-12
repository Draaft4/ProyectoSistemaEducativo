package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int codigo;
	
	private int numHoras;
	
	private String nombreAsignatura;
	
	private Docente docente;
	
	
	private ArrayList<Calificaciones> calificaciones;
	
	private ArrayList<String> contenido;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public ArrayList<Calificaciones> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public ArrayList<String> getContenido() {
		return contenido;
	}

	public void setContenido(ArrayList<String> contenido) {
		this.contenido = contenido;
	}

	
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", numHoras=" + numHoras + ", nombreAsignatura=" + nombreAsignatura+ "]";
	}
	
	
	
}
