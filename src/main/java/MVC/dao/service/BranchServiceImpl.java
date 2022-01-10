package MVC.dao.service;

import MVC.dao.repository.BranchRepository;
import MVC.dao.domain.Branch;
import MVC.dao.service.exception.EntityAlreadyExistException;
import MVC.dao.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    @Autowired
    private final BranchRepository branchRepository;
    private final List<Branch> branches = new ArrayList<>();

    @Override
    public Collection<Branch> findAll() {
        return (Collection<Branch>) branchRepository.findAll();
    }

    @Override
    public Collection<Branch> findByCity(String city) {
        return branchRepository.findByCity(city);
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public void insert(Branch branch) {
        if (branchRepository.findById(branch.getId()).isEmpty())
            branchRepository.save(branch);
        else throw new EntityAlreadyExistException("there is route with id " + branch.getId());
    }

    @Override
    public void update(Branch branch) {
        if (branchRepository.existsById(branch.getId()))
            branchRepository.save(branch);
        else throw new EntityNotExistException("no branch with that id");
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }
}