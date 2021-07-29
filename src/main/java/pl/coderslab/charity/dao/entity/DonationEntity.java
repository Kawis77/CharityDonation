package pl.coderslab.charity.dao.entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donation")


public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;
    @ManyToMany
    private List<CategoryEntity> categoryEntity;

    public List<CategoryEntity> getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(List<CategoryEntity> categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    @OneToOne     //tutaj musze poprawic relacje
    private InstitutionEntity institutionEntity;

    @Column(length = 200)
    private String street;


    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column
    private LocalDate pckUpDate;

    @Column
    private LocalTime pickUpTime;

    @Column
    private String pickUpComment;

    public DonationEntity() {
    }

    public DonationEntity(Long id, Integer quantity, List<CategoryEntity> categoryEntity, InstitutionEntity institutionEntity, String street, String city, String zipCode, LocalDate pckUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categoryEntity = categoryEntity;
        this.institutionEntity = institutionEntity;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pckUpDate = pckUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<CategoryEntity> getCategory() {
        return categoryEntity;
    }

    public void setCategory(List<CategoryEntity> categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public InstitutionEntity getInstitution() {
        return institutionEntity;
    }

    public void setInstitution(InstitutionEntity institutionEntity) {
        this.institutionEntity = institutionEntity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPckUpDate() {
        return pckUpDate;
    }

    public void setPckUpDate(LocalDate pckUpDate) {
        this.pckUpDate = pckUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }


}
