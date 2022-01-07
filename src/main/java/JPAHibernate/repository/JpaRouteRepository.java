package JPAHibernate.repository;

import JPAHibernate.service.dao.domain.Route;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaRouteRepository implements RouteRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Route insert(Route route) {
        em.persist(route);
        return route;
    }

    @Override
    public Route findById(long id) {
        return em.find(Route.class, id);
    }

    @Override
    public Route update(Route route) {
        em.merge(route);
        return route;
    }

    @Override
    public Route delete(Route route) {
        if (em.contains(route))
            em.remove(route);
        else
            em.remove(em.merge(route));
        return route;
    }
}
