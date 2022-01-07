package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Calificaciones;

@Local
public interface CalificacionesONLocal {
	
	public void insertarCalificaciones(Calificaciones c) throws Exception;
	
}
