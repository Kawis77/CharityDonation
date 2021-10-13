package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.InstitutionService;

import java.util.logging.Logger;

@Controller
public class InstitutionController {

    private final InstitutionService institutionService;
    private static final Logger LOGGER = Logger.getLogger(DonationController.class.getName());

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping(value = "/institutionview")
    public String allDonationView(Model model) {
        LOGGER.info("allInstitutionView()");
        model.addAttribute("allInstitutionView", institutionService.allInstitution());
        return "institutionview";
    }
}
