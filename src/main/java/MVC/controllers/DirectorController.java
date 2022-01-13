package MVC.controllers;

import MVC.domain.Assignment;
import MVC.domain.Status;
import MVC.domain.User;
import MVC.repository.AssignmentRepository;
import MVC.repository.DocumentRepository;
import MVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/director")
@PreAuthorize("hasAuthority('director')")
public class DirectorController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping
    public void giveAssignment(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            Map<String, Object> model){
        Assignment assignment = new Assignment(name, user);
        assignmentRepository.save(assignment);

        Iterable<Assignment> assignments = assignmentRepository.findAll();
        model.put("assignments", assignments);
    }

    @GetMapping("{assignment}")
    public void cancelAssignment(@PathVariable Assignment assignment){
        assignment.setStatus(Collections.singleton(Status.closed));
    }

    @GetMapping
    public void putSignature(Assignment assignment) {
        documentRepository.findByIdAssigment(assignment.getId()).setDirectorSignature(true);
        assignment.setStatus(Collections.singleton(Status.acceptedForExecution));
    }

    @GetMapping
    public void submitForRevision(Assignment assignment) {
        documentRepository.findByIdAssigment(assignment.getId()).setDirectorSignature(false);
        assignment.setStatus(Collections.singleton(Status.active));

    }

}
