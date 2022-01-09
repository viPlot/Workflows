package DataJpa.dao.service;

import DataJpa.dao.enums.Branch;

import java.util.Collection;
import java.util.Optional;


public interface BranchService {
    Collection<Branch> findAll();
    Collection<Branch> findByCity(String city);
    Optional<Branch> findById(Long id);
    void insert(Branch branch);
    void update(Branch branch);
    void delete(Branch branch);
}
