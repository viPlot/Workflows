package MVC.controllers;

import MVC.domain.User;
import MVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
