package ec.edu.ups.SistemaEducativo1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Calificaciones")
public class Calificaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cali_id")
	private int id;
	
	@Column(name = "cali_notaParcial")
	private double notaParcial;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNotaParcial() {
		return notaParcial;
	}

	public void setNotaParcial(double notaParcial) {
		this.notaParcial = notaParcial;
	}
	
	
}
