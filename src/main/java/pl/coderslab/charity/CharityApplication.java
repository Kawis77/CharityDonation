package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.coderslab.charity.service.EmailService;

@SpringBootApplication
public class CharityApplication {

//    @Autowired
//    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail(){
//        emailService.SendEmail("krisjavatest@gmail.com","halo" , "halo");
//    }
//

}
