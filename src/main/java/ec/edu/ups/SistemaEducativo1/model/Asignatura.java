package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Asignatura")
public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asig_codigo")
	private int codigo;
	
	@Column(name = "asig_numHoras")
	private int numHoras;
	
	@Column(name = "asig_asignatura")
	private String nombreAsignatura;
	
	@OneToOne
	@JoinColumn(name = "doc_id")
	private Docente docente;
	
	@JoinColumn(name = "cali_id")
	private ArrayList<Calificaciones> calificaciones;
	
	@Column(name = "asig_contenido")
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
