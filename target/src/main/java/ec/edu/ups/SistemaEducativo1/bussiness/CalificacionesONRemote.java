package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Remote;

import ec.edu.ups.SistemaEducativo1.model.Calificaciones;

@Remote
public interface CalificacionesONRemote {
	
	public void insertarCalificaciones(Calificaciones c) throws Exception;
}
