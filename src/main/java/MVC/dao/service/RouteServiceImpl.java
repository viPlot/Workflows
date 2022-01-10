package MVC.dao.service;

import MVC.dao.domain.Route;
import MVC.dao.repository.RouteRepository;
import MVC.dao.service.exception.EntityAlreadyExistException;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RouteServiceImpl implements RouteService{
    private final RouteRepository routeRepository;
    private final List<Route> routes = new ArrayList<>();

    @Override
    public void insert(Route route) {
        if (routeRepository.findById(route.getId()).isEmpty())
            routes.add(route);
        else throw new EntityAlreadyExistException("there is route with id " + route.getId());
    }

    @Override
    public void update(Route route) {
        if (routeRepository.existsById(route.getId()))
            routeRepository.save(route);
    }

    @Override
    public void delete(Route route) {
        routeRepository.delete(route);
    }
}
