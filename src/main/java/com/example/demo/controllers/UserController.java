package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
