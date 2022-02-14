package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Solicitudes")
public class Solicitudes implements Serializable{

	@Override
	public String toString() {
		return "Solicitudes [id=" + id + ", contenido=" + contenido + ", destinatario=" + destinatario + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "soli_id")
	private int id;
	
	@Column(name = "soli_contenido")
	private String contenido;
	
	@JoinColumn(name = "doc_id")
	@Column(name="soli_des")
	private Docente destinatario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Docente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Docente destinatario) {
		this.destinatario = destinatario;
	}
	
	
	
	
}
