package BootAndShell.service.dao;

import BootAndShell.repository.BranchRepository;
import BootAndShell.service.dao.domain.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService{
    private final BranchRepository branchRepository;

    @Override
    public Collection<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Collection<Branch> findByCity(String city) {
        return branchRepository.findByCity(city);
    }

    @Override
    public void insert(Branch branch) {
        branchRepository.insert(branch);
    }

    @Override
    public void update(Branch branch) {
        branchRepository.update(branch);
    }

    @Override
    public void delete(Branch branch) {
        branchRepository.delete(branch);
    }
}
