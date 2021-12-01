package pl.coderslab.charity.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.dao.entity.InstitutionEntity;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationFormService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.web.model.DonationModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import static pl.coderslab.charity.web.controller.DonationFormController.*;

@Controller
@RequestMapping(value = "/form")
@SessionAttributes(names = {ATTRIBUTE_CATEGORY, ATTRIBUTE_QUANTITY, ATTRIBUTE_INSTITUTION, ATTRIBUTE_DONATIONDETAILS})
public class DonationFormController {
    private static final Logger LOGGER = Logger.getLogger(DonationFormController.class.getName());

    static final String ATTRIBUTE_CATEGORY = "category";
    static final String ATTRIBUTE_QUANTITY = "quantity";
    static final String ATTRIBUTE_INSTITUTION = "institution";
    static final String ATTRIBUTE_DONATIONDETAILS = "donationDetails";

    private final DonationFormService donationFormService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationFormController(DonationFormService donationFormService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationFormService = donationFormService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping(value = "/category")
    public String categoryView(Model model) {
        LOGGER.info("categoryView()");
        List<CategoryEntity> allCategories = categoryService.allCategory();
        allCategories.sort(Comparator.comparing(CategoryEntity::getId));
        model.addAttribute("categories", allCategories);
        return "category";
    }

    @PostMapping(value = "/category")
    public String categoryChoose(@RequestParam(name = "categoryId") List<String> categoryId, ModelMap modelMap) {
        LOGGER.info("categoryChoose()");
        modelMap.addAttribute(ATTRIBUTE_CATEGORY, categoryId);
        LOGGER.info("chosen category: " + categoryId);
        return "quantity";
    }

    @PostMapping(value = "/quantity")
    public String quantityChoose(@RequestParam(name = "quantityId") String quantityId, ModelMap modelMap, Model model) {
        LOGGER.info("quantityChoose()");
        modelMap.addAttribute(ATTRIBUTE_QUANTITY, quantityId);
        model.addAttribute("institutionfind", institutionService.allInstitution());
        return "institution";
    }

    @PostMapping(value = "/institution")
    public String institutionChoose(@RequestParam(name = "institutionId") String institutionId, ModelMap modelMap) {
        LOGGER.info("quantityChoose()");
        modelMap.addAttribute(ATTRIBUTE_INSTITUTION, institutionId);
        String quantity = (String) modelMap.getAttribute(ATTRIBUTE_QUANTITY);
        LOGGER.info("chosen Quantity: " + quantity);
        return "donationDetails";
    }

    @PostMapping(value = "/donationdetails")
    public String donationDetailsProvide(ModelMap modelMap, @ModelAttribute DonationModel donationModel) {
        LOGGER.info("donationDetailsProvide(" + donationModel + ")");
        String quantityAttribute = (String) modelMap.getAttribute(ATTRIBUTE_QUANTITY);
        donationModel.setQuantity(Integer.valueOf(quantityAttribute));
        LOGGER.info("donation Model : " + donationModel);
        modelMap.addAttribute(ATTRIBUTE_DONATIONDETAILS, donationModel);

        List<String> categories = (List<String>) modelMap.getAttribute(ATTRIBUTE_CATEGORY);

        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (String category : categories) {
            CategoryEntity categoryEntity = categoryService.getById(Long.valueOf(category));
            categoryEntities.add(categoryEntity);
        }

        String institutions = (String) modelMap.getAttribute(ATTRIBUTE_INSTITUTION);

        InstitutionEntity institutionEntity = institutionService.getById(Long.valueOf(institutions));

        donationModel.setInstitutionEntity(institutionEntity);
        donationModel.setCategoryEntity(categoryEntities);

        donationFormService.create(donationModel);

        return "endform";
    }

    @PostMapping(value = "/endform/{id}")
    public String endFormView(ModelMap modelMap, Model model, @PathVariable Long id) {
        LOGGER.info("endFormView()");
        DonationModel donationDetails = (DonationModel) modelMap.getAttribute(ATTRIBUTE_DONATIONDETAILS);

        model.addAttribute("acceptcategory", donationFormService.findById(id));
        LOGGER.info("chosen donationDetails: " + donationDetails);
        return "endform";
    }

}
