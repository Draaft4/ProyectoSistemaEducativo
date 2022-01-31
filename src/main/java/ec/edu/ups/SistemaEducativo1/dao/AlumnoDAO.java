package ec.edu.ups.SistemaEducativo1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.SistemaEducativo1.model.Alumno;

@Stateless
public class AlumnoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Alumno alumno) throws Exception{
		em.persist(alumno);
		throw new Exception("Se ha creado correctamente");
	}
	
	public void update(Alumno alumno) throws Exception{
		em.merge(alumno);
		throw new Exception("Se ha actualizado correctamente");
	}
	
	public Alumno read(String id) {
		Alumno alumno = em.find(Alumno.class, id);
		return alumno;
	}
	
	public void delete(int id) throws Exception{
		Alumno alumno = em.find(Alumno.class, id);
		em.remove(alumno);
		throw new Exception("Se ha eliminado correctamente");
	}
	
	public List<Alumno> getList(){
		List<Alumno> listado = new ArrayList<Alumno>();
		
		String jpql = "SELECT op FROM Alumno op";
		
		Query query = em.createQuery(jpql, Alumno.class); 
	
		listado = query.getResultList();
		
		return listado;
	}
	
	
}
