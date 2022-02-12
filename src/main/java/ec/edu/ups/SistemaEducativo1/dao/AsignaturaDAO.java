package ec.edu.ups.SistemaEducativo1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public Asignatura read(int codigo) {
		Asignatura asig = em.find(Asignatura.class, codigo);
		return asig;
	}
	
	public void delete(int codigo) throws Exception{
		Asignatura asig = em.find(Asignatura.class, codigo);
		em.remove(asig);
		throw new Exception("Se ha eliminado correctamente");
	}
	
	
	public List<Asignatura> getList(){
		List<Asignatura> listado = new ArrayList<Asignatura>();
		
		String jpql = "SELECT op FROM Asignatura op";
		
		Query query = em.createQuery(jpql, Asignatura.class); 
	
		listado = query.getResultList();
		
		return listado;
	}
	
}
