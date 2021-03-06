package pl.coderslab.charity.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.List;

@SpringBootTest
class DonationServiceSpringIntegrationTest {

    @Autowired
    private DonationService donationService; //private = specyfikator dostepu / hermetyzowanie

    @Test
    void givenModel_whenCrated_thanCheckIdIsNotNull() {
        //given
        DonationModel donationModel = new DonationModel();
        donationModel.setQuantity(20);
        donationModel.setStreet("ABC 7");
        //when
        DonationModel createdDonationModel = donationService.create(donationModel);
        //than

        Assertions.assertNotNull(createdDonationModel.getId(), "Id is null");

    }

    @Test
    void givenModel_whenDelete_thanCheckIdIsNull() {
        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationModel donationModel = new DonationModel();
        donationModel.setStreet("ABC3");
        donationModel.setQuantity(20);
        //when
        DonationModel createdDonationModel = donationService.create(donationModel);
        DonationEntity donationEntity1 = donationMapper.from(createdDonationModel);
        donationService.removeDonation(donationEntity1);
        List<DonationEntity> donationEntities = donationService.allDonation();
        //than
        Assertions.assertEquals(0,donationEntities.size(), "List is not empty");

    }

    @Test
    public void givenDonationList_whenAllDonation_thanCheckSum() {
        //given
        DonationModel donationModel = new DonationModel();
        donationModel.setQuantity(12);
        donationModel.setStreet("ABC");

        //when
        DonationModel createNewDonation = donationService.create(donationModel);
        List<DonationEntity> donationEntitiesList = donationService.allDonation();

        //than
        Assertions.assertNotNull(createNewDonation.getId(), "Id is null");
        Assertions.assertEquals(1, donationEntitiesList.size(), "Expect diffrent value");
    }


    @Test
    void givenDonationModel_whenCreateAndCount_thanSumQuantitiesIsCorrect(){
        //given
        DonationModel donationModel = new DonationModel();
        donationModel.setQuantity(25);

        //when
        DonationModel createNewDonation = donationService.create(donationModel);
        donationService.create(DonationModel.builder().quantity(15).build());
        Long sumOfQuantities = donationService.count();
//        List<DonationEntity> donationEntitiesList = donationService.allDonation();

        //than
        Assertions.assertEquals(40 , sumOfQuantities);
//        Assertions.assertEquals(1, donationEntitiesList.size(), "Expect diffrent value");
    }
}