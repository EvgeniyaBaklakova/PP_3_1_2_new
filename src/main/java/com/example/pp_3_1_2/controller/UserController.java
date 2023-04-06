package com.example.pp_3_1_2.controller;

import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        var users = service.getAllUsers();
        model.addAttribute("allUsers", users);
        return "showUsers";
    }
    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
            service.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model){
        model.addAttribute("user", service.getUserById(id));
        return "updateUser";
    }
    @PostMapping("edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        service.deleteUser(id);
        return "redirect:/";
    }
}