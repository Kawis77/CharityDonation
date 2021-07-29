package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static pl.coderslab.charity.web.controller.DonationFormController.*;

@Controller
@RequestMapping(value = "/form")
@SessionAttributes(names = {ATTRIBUTE_CATEGORY, ATTRIBUTE_QUNATITY, ATTRIBUTE_INSTITUTION, ATTRIBUTE_DONATIONDETAILS})
public class DonationFormController {
    private static final Logger LOGGER = Logger.getLogger(DonationFormController.class.getName());


    static final String ATTRIBUTE_CATEGORY = "category";
    static final String ATTRIBUTE_QUNATITY = "quantity";
    static final String ATTRIBUTE_INSTITUTION = "institution";
    static final String ATTRIBUTE_DONATIONDETAILS = "donationDetails";


    @GetMapping(value = "/category")
    public String categoryView(ModelMap modelMap) {
        LOGGER.info("categoryView()");
        modelMap.addAttribute(ATTRIBUTE_CATEGORY, null);
        return "category";
    }

    @PostMapping(value = "/category")
    public String categoryChoose(@RequestParam(name = "categoryId") String categoryId, ModelMap modelMap) {
        LOGGER.info("categoryChoose()");
        modelMap.addAttribute(ATTRIBUTE_CATEGORY, categoryId);
        return "quantity";
    }

    @PostMapping(value = "/quantity")
    public String quantityChoose(@RequestParam(name = "quantityId") String quantityId, ModelMap modelMap) {
        LOGGER.info("quantityChoose()");
        modelMap.addAttribute(ATTRIBUTE_QUNATITY, quantityId);
        String category = (String) modelMap.getAttribute(ATTRIBUTE_CATEGORY);
        LOGGER.info("chosen category: " + category);

        return "institution";
    }

    @PostMapping(value = "/institution")
    public String institutionChoose(@RequestParam(name = "institutionId") String institutionId, ModelMap modelMap) {
        LOGGER.info("quantityChoose()");
        modelMap.addAttribute(ATTRIBUTE_INSTITUTION, institutionId);
        String quantity = (String) modelMap.getAttribute(ATTRIBUTE_QUNATITY);
        LOGGER.info("chosen Quantity: " + quantity);

        return "donationDetails";
    }

    @PostMapping(value = "/donationdetails")
    public String donationDeatilsChoose(@RequestParam(name = "cityId") String cityId, @RequestParam(name = "zipCodeId") String zipCodeId,
                                        @RequestParam(name = "pickUpDateId") LocalDate pickUpDateId,
                                        @RequestParam(name = "pickUpTimeId") LocalTime pickUpTimeId,
                                        @RequestParam(name = "pickUpCommentId") String pickUpCommentId, ModelMap modelMap) {
        LOGGER.info("institutionChoose()");
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, cityId);
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, zipCodeId);
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, pickUpDateId);
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, pickUpTimeId);
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, pickUpCommentId);
        String institution = (String) modelMap.getAttribute(ATTRIBUTE_INSTITUTION);
        LOGGER.info("chosen Institution: " + institution);

        return "endform";
    }

    @GetMapping (value = "/endform")
    public String endFormView(ModelMap modelMap) {
        LOGGER.info("donationDetailsView()");
        String donationDetails = (String) modelMap.getAttribute(ATTRIBUTE_DONATIONDETAILS);
        LOGGER.info("chosen donationDetails: " + donationDetails);

        return "category";
    }

}
