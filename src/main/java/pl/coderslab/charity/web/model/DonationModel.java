package pl.coderslab.charity.web.model;

import lombok.Data;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.dao.entity.InstitutionEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationModel {
    private Long id;

    private Integer quantity;

    private List<CategoryEntity> categoryEntity;

    private InstitutionEntity institutionEntity;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pckUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
