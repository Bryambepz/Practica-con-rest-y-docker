package ec.edu.ups.sd.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public Autos read(String placa) {
		Autos c = em.find(Autos.class, placa);
		return c;
	}
	
	
	public List<Autos> getList() {
		String jpql = "Select p From Autos p";

		Query q = (Query) em.createQuery(jpql, Autos.class);

		return ((TypedQuery<Autos>) q).getResultList();
	}

	public List<Autos> getListNombre(String filtro) {
		String jpql = "Select p From Persona p" + " where nombre LIKE ?1";

		Query q = (Query) em.createQuery(jpql, Autos.class);
		((javax.persistence.Query) q).setParameter(1, filtro);
		return ((javax.persistence.Query) q).getResultList();
	}
}
