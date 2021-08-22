package pl.coderslab.charity.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.entity.InstitutionEntity;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

@SpringBootTest
class DonationServiceTest {

    @Autowired
    private DonationService donationService;

    @Test
    void givenDonationServiceWhenUserThenDonationInDB(){
        //given
        DonationModel donationModel = new DonationModel();
        DonationMapper donationMapper = new DonationMapper();
        CategoryEntity categoryEntity = new CategoryEntity();
        InstitutionEntity institutionEntity = new InstitutionEntity();
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(1L);
        donationEntity.setZipCode("22");
        donationEntity.setPickUpComment("asdasd");
        donationEntity.setStreet("xxxx");
        donationEntity.setPckUpDate("20-12-2020");
        donationEntity.setPickUpTime("20:34");

        //when
        DonationModel donationModel1 = donationMapper.from(donationEntity);
        donationService.create(donationModel1);

        //then
        Assertions.assertNotNull(donationModel1 , "Is not null");

    }
}