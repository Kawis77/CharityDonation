package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.logging.Logger;

@Controller
public class DonationController {
    private static final Logger LOGGER = Logger.getLogger(DonationController.class.getName());

    private final DonationService donationService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

//    public void create(DonationModel donationModel) {
//        LOGGER.info("create(" + donationModel + ")");
//        donationService.create(donationModel);
//    }

    @GetMapping("/")

    public String homePageView(Model model, DonationModel donationModel) {
        model.addAttribute("alldonation", donationService.count(donationModel));
        model.addAttribute("allquantity", donationService.sumQuantity());
        model.addAttribute("allinstitution", institutionService.allInstitution());

        return "index";

    }

    @GetMapping(value = "/count")
    public String countView(Model model , DonationModel donationModel) {
        LOGGER.info("categoryView()");
        model.addAttribute("count" , donationService.count(donationModel));

        return "count";
    }

    @GetMapping(value = "/countquantity")
    public String categoryView( Model model) {
        LOGGER.info("countQuantityView()");
        model.addAttribute("countquantity" , donationService.sumQuantity());
        return "countquantity";
    }
}
