package BootAndShell.repository;

import BootAndShell.service.dao.domain.Branch;

import java.util.Collection;
import java.util.Optional;

public interface BranchRepository {
    Collection<Branch> findAll();
    Optional<Branch> findById(long id);
    Collection<Branch> findByCity(String city);
    void insert(Branch branch);
    void update(Branch branch);
    void delete(Branch branch);
}
