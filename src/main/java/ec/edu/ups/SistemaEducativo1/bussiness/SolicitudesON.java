package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.SolicitudesDAO;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Stateless
public class SolicitudesON implements SolicitudesONLocal,SolicitudesONRemote {
	
	@Inject
	private SolicitudesDAO dao;
	
	public void crearSolicitud(Solicitudes s) throws Exception {
		dao.insert(s);
	}
	
	public List<Solicitudes> lista (){
		return dao.getList();
	}
	
}
