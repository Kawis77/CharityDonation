package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dao.entity.UserEntity;
import pl.coderslab.charity.service.UserMenagerService;
import pl.coderslab.charity.service.mapper.UserMapper;
import pl.coderslab.charity.web.model.UserModel;

@Controller
public class RegistrationController {
    private final UserMenagerService userMenagerService;

    public RegistrationController(UserMenagerService userMenagerService) {
        this.userMenagerService = userMenagerService;
    }

    @GetMapping("/register")
    public String prepareRegistration(Model model) {
        model.addAttribute("user", new UserEntity());
        return "/user/registration";

    }

    @PostMapping("/register")
    public String proccesRegistriation(UserModel user) {
        userMenagerService.registerUser(user);
        return "redirect:/login";
    }
}

