package ec.edu.ups.SistemaEducativo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Solicitudes")
public class Solicitudes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "soli_id")
	private int id;
	
	@Column(name = "soli_contenido")
	private String contenido;

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
	
	
	
	
}
