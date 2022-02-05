package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.SistemaEducativo1.dao.DocenteDAO;
import ec.edu.ups.SistemaEducativo1.model.Docente;

@Stateless
public class DocenteON implements DocenteONLocal,DocenteONRemote{
	
	@Inject
	private DocenteDAO dao;
	
	public void crearDocente(Docente d) throws Exception {
		dao.insert(d);
	}
	
	public List<Docente> listarDocente() {
		return dao.getList();
	}
	
}
