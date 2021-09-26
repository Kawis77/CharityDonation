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
class DonationServiceSpringTest {

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
        //than
        Assertions.assertNull(donationEntity1.getId(), "is not null");
    }

    @Test
    public void givenDonationList_whenCheckList_thanSum() {
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


}