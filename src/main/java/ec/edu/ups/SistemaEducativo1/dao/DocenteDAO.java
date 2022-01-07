package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.SistemaEducativo1.model.Docente;


@Stateless
public class DocenteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Docente docente) throws Exception{
		em.persist(docente);
		throw new Exception("Se ha creado correctamente");
	}
	
	public void update(Docente docente) throws Exception{
		em.merge(docente);
		throw new Exception("Se ha actualizado correctamente");
	}
	
	public Docente read(String cedula) {
		Docente docente = em.find(Docente.class, cedula);
		return docente;
	}
	
	public void delete(String cedula) throws Exception{
		Docente docente = em.find(Docente.class, cedula);
		em.remove(docente);
		throw new Exception("Se ha eliminado correctamente");
	}
	
}
