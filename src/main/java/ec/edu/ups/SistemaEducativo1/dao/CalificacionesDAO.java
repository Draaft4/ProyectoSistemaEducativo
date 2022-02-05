package ec.edu.ups.SistemaEducativo1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public List<Calificaciones> getList(){
		List<Calificaciones> listado = new ArrayList<Calificaciones>();
		
		String jpql = "SELECT op FROM Calificaciones op";
		
		Query query = em.createQuery(jpql, Calificaciones.class); 
	
		listado = query.getResultList();
		
		return listado;
	}
	
	
}
