package MVC.dao.controller;

import MVC.dao.domain.Branch;
import MVC.dao.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping
    Collection<Branch> findAll() {
        return branchService.findAll();
    }

    @GetMapping
    Collection<Branch> findByCity(String city) {
        return branchService.findByCity(city);
    }

    @GetMapping("/branch/{id:\\d+}")
    Branch findById(Long id) {
        return branchService.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("no branch with id:" + id));
    }

    @GetMapping
    void insert(Branch branch) {
        branchService.insert(branch);
    }

    @GetMapping
    void update(Branch branch) {
        if (branchService.findById(branch.getId()).isPresent())
            branchService.update(branch);
        else throw new EntityNotFoundException("no such branch");
    }

    @GetMapping
    void delete(Branch branch) {
        if (branchService.findById(branch.getId()).isPresent())
            branchService.delete(branch);
        else throw new EntityNotFoundException("no such branch");
    }
}
