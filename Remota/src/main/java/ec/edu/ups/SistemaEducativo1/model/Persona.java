package ec.edu.ups.SistemaEducativo1.model;

import java.io.Serializable;
import java.util.Date;


public class Persona implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String cedula;
	
	
	private String nombre;
	
	
	private String direccion;
	
	
	private Date fechaNacimiento;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String toS() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
}
