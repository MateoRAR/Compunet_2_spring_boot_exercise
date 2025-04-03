package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String saveUser(User user) {
        try {
            userService.createUser(user);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
