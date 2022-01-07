package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public Alumno read(String cedula) {
		Alumno alumno = em.find(Alumno.class, cedula);
		return alumno;
	}
	
	public void delete(String cedula) throws Exception{
		Alumno alumno = em.find(Alumno.class, cedula);
		em.remove(alumno);
		throw new Exception("Se ha eliminado correctamente");
	}
	
	
}
