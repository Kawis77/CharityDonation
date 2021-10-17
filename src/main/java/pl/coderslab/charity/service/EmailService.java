package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void SendEmail(String from, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("javakristest@gmail.com");
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
        System.out.println("Send");


    }
}

