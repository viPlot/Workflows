package BootAndShell.service.dao;

import BootAndShell.service.dao.domain.Branch;

import java.util.Collection;


public interface BranchService {
    Collection<Branch> findAll();
    Collection<Branch> findByCity(String city);
    void insert(Branch branch);
    void update(Branch branch);
    void delete(Branch branch);
}
