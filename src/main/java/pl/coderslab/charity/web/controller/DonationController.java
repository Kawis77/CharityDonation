package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.entity.InstitutionEntity;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.NoSuchElementException;
import java.util.Optional;
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
        model.addAttribute("sumdonation", donationService.count(donationModel));
        model.addAttribute("sumquantity", donationService.sumQuantity());
        model.addAttribute("allinstitution", institutionService.allInstitution());

        return "index";

    }

    @GetMapping(value = "/count")
    public String countView(Model model, DonationModel donationModel) {
        LOGGER.info("categoryView()");
        model.addAttribute("count", donationService.count(donationModel));

        return "count";
    }

    @GetMapping(value = "/countquantity")
    public String categoryView(Model model) {
        LOGGER.info("countQuantityView()");
        model.addAttribute("countquantity", donationService.sumQuantity());
        return "countquantity";
    }

    @GetMapping(value = "/list")
    public String allDonationView(Model model) {
        LOGGER.info("allDonationView()");
        model.addAttribute("allDonationView", donationService.allDonation());
        return "donationlist";
    }

    @GetMapping(value = "/onedonation/{id}")
    public String oneDonationView(Model model, @PathVariable Long id) {
        LOGGER.info("oneDonationView");
        model.addAttribute("viewAlldonation" , donationService.allDonation());
        Optional<DonationEntity> optionalInstitutionEntity = donationService.findDonationById(id);
        DonationEntity donationEntity = optionalInstitutionEntity.orElseThrow(() -> new NoSuchElementException());
        model.addAttribute("oneDonation" , donationEntity);
        return "onedonation";
    }
}
