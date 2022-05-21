package ec.edu.ups.sd.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.sd.modelo.Autos;

@Stateless
public class AutosDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Autos a) {
		em.persist(a);
	}
	
	public void update(Autos per) {
		em.merge(per);
	}

	public Autos read(int id) {
		Autos c = em.find(Autos.class, id);
		return c;
	}

	public List<Autos> getList() {
		String jpql = "Select p From Autos p";

		Query q = em.createQuery(jpql, Autos.class);

		return q.getResultList();
	}
	
//	public List<Autos> getListNombre(String filtro) {
//		String jpql = "Select p From Persona p" + " where nombre LIKE ?1";
//
//		Query q = em.createQuery(jpql, Autos.class);
//		q.setParameter(1, filtro);
//		return q.getResultList();
//	}
}
