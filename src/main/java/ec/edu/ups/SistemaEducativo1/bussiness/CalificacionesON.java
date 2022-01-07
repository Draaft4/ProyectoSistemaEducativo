package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.CalificacionesDAO;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;

@Stateless
public class CalificacionesON implements CalificacionesONLocal,CalificacionesONRemote{
	
	@Inject
	private CalificacionesDAO dao;
	
	public void insertarCalificaciones(Calificaciones c) throws Exception {
		dao.insert(c);
	}
	
}
