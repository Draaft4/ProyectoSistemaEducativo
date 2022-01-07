package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.AsignaturaDAO;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;

@Stateless
public class AsignaturaON implements AsignaturaONLocal,AsignaturaONRemote{
	
	@Inject
	private AsignaturaDAO dao;
	
	public void crearAsignatura(Asignatura a) throws Exception {
		dao.insert(a);
	}
	
}
