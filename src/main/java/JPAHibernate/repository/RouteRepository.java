package JPAHibernate.repository;

import JPAHibernate.service.dao.domain.Route;

public interface RouteRepository {
    Route insert(Route route);  //C - create
    Route findById(long id); //R - read
    Route update(Route route); //U - update
    Route delete(Route route); //D - delete
}
