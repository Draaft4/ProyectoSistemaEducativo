package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Stateless
public class SolicitudesDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Solicitudes soli) throws Exception{
		em.persist(soli);
		throw new Exception("Se ha creado correctamente");
	}
	
	public void update(Solicitudes soli) throws Exception{
		em.merge(soli);
		throw new Exception("Se ha actualizado correctamente");
	}
	
	public Solicitudes read(String cedula) {
		Solicitudes soli = em.find(Solicitudes.class, cedula);
		return soli;
	}
	
	public void delete(String cedula) throws Exception{
		Solicitudes soli = em.find(Solicitudes.class, cedula);
		em.remove(soli);
		throw new Exception("Se ha eliminado correctamente");
	}
	
}
