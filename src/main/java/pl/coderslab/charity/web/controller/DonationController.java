package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.logging.Logger;

@Controller
public class DonationController {
    private static final Logger LOGGER = Logger.getLogger(DonationController.class.getName());

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    public void create(DonationModel donationModel) {
        LOGGER.info("create(" + donationModel + ")");
        donationService.create(donationModel);
    }
}
