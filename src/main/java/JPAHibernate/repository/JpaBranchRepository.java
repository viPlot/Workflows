package JPAHibernate.repository;

import JPAHibernate.service.dao.domain.Branch;
import JPAHibernate.service.dao.domain.Route;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Optional;

public class JpaBranchRepository implements BranchRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Branch> findAll() {
        TypedQuery<Branch> query = em.createQuery("select b from Branch b", Branch.class);
        return query.getResultList();
    }

    @Override
    public Collection<Branch> findById(long id) {
        TypedQuery<Branch> query = em.createQuery("select b from Branch b where b.id=:id",
                Branch.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public Collection<Branch> findByCity(String city) {
        TypedQuery<Branch> query = em.createQuery("select b from Branch b where b.city=:city",
                Branch.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public void insert(Branch branch) {
        em.persist(branch);
    }

    @Override
    public void update(Branch branch) {
        em.merge(branch);
    }

    @Override
    public void delete(Branch branch) {
        if (em.contains(branch))
            em.remove(branch);
        else
            em.remove(em.merge(branch));
    }
}
