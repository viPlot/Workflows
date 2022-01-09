package DataJpa.dao.service;

import DataJpa.dao.repository.BranchRepository;
import DataJpa.dao.enums.Branch;
import DataJpa.dao.service.exception.EntityAlreadyExistException;
import DataJpa.dao.service.exception.EntityDoesnotExistException;
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
            branches.add(branch);
        else throw new EntityAlreadyExistException("there is route with id " + branch.getId());
    }

    @Override
    public void update(Branch branch) {
        if (branchRepository.existsById(branch.getId()))
            branchRepository.save(branch);
        else throw new EntityDoesnotExistException("no branch with that id");
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }
}