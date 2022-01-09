package DataJpa.dao.service;

import DataJpa.dao.enums.Branch;
import DataJpa.dao.enums.Route;

import java.util.Collection;

public interface RouteService {
    void insert(Route route);
    void update(Route route);
    void delete(Route route);
}
