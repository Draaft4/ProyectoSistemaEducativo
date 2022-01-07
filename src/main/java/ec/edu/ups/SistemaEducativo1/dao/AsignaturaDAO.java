package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.SistemaEducativo1.model.Asignatura;

@Stateless
public class AsignaturaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Asignatura asig) throws Exception{
		em.persist(asig);
		throw new Exception("Se ha creado correctamente");
	}
	
	public void update(Asignatura asig) throws Exception{
		em.merge(asig);
		throw new Exception("Se ha actualizado correctamente");
	}
	
	public Asignatura read(String cedula) {
		Asignatura asig = em.find(Asignatura.class, cedula);
		return asig;
	}
	
	public void delete(String cedula) throws Exception{
		Asignatura asig = em.find(Asignatura.class, cedula);
		em.remove(asig);
		throw new Exception("Se ha eliminado correctamente");
	}
	
}
