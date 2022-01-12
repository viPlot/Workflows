package MVC.controllers;

import MVC.domain.Assignment;
import MVC.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Assignment> assignments = assignmentRepository.findAll();
        model.put("assignments", assignments);
        return "main_page";
    }
}
