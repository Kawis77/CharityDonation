package pl.coderslab.charity.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.EmailService;


@Controller
    public class SendEmailController {

        @Autowired
        private EmailService emailService;

        @GetMapping("/emailsend")
        public String SendEmailGet(){
            return "email";
        }

        @PostMapping("/emailsend")
        public String SendEmailPost(@RequestParam String from , @RequestParam String topic , @RequestParam String text) {

        emailService.SendEmail(from , topic , text);

            return "email";
        }
    }
