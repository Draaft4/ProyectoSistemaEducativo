package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.SistemaEducativo1.model.Calificaciones;


@Stateless
public class CalificacionesDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Calificaciones cali) throws Exception{
		em.persist(cali);
		throw new Exception("Se ha creado correctamente");
	}
	
	public void update(Calificaciones cali) throws Exception{
		em.merge(cali);
		throw new Exception("Se ha actualizado correctamente");
	}
	
	public Calificaciones read(String cedula) {
		Calificaciones cali = em.find(Calificaciones.class, cedula);
		return cali;
	}
	
	public void delete(String cedula) throws Exception{
		Calificaciones cali = em.find(Calificaciones.class, cedula);
		em.remove(cali);
		throw new Exception("Se ha eliminado correctamente");
	}
}
