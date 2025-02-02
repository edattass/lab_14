package org.aeh.lab13.controller;

import org.aeh.lab13.model.User;
import org.aeh.lab13.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        try {
            userService.createUser(username, email, password);
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }
}
