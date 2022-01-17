package ec.edu.ups.SistemaEducativo1.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.SistemaEducativo1.model.Persona;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(int id) {
		Persona persona = em.find(Persona.class, id);
		return persona;
	}
	
	public void delete(int id){
		Persona persona = em.find(Persona.class, id);
		em.remove(persona);
	}
	
}
