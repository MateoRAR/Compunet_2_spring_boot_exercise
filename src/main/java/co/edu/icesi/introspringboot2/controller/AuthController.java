package co.edu.icesi.introspringboot2.controller;

import co.edu.icesi.introspringboot2.DTO.AuthRequest;
import co.edu.icesi.introspringboot2.DTO.AuthResponse;
import co.edu.icesi.introspringboot2.entity.Student;
import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.service.UserService;
import co.edu.icesi.introspringboot2.service.impl.CustomUserDetailsService;
import co.edu.icesi.introspringboot2.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        //Proceso de autenticación


        //Creación de token
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtService.generateToken(userDetails);

        AuthResponse response = new AuthResponse(jwt);
        return ResponseEntity.ok(response);
    }

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
