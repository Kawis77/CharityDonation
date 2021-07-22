package pl.coderslab.charity.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.web.model.DonationModel;

import static org.junit.jupiter.api.Assertions.*;

class DonationMapperTest {

    @Test
    void givenMapperAndModel_whenFrom_thenEntityIsNotNull() {
        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationModel donationModel = new DonationModel();
        donationModel.setId(1L);
        donationModel.setCity("Warszawa");

        //when
        DonationEntity donationEntity = donationMapper.from(donationModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(donationEntity, "DonationEntity is null"),
                () -> Assertions.assertNotNull(donationEntity.getId(), "Id is null"),
                () -> Assertions.assertNotNull(donationEntity.getCity(), "City is null")
        );
    }

    @Test
    void givenMapperAndModel_whenFrom_thenModelIsNotNull(){

        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(1L);
        donationEntity.setCity("Warszawa");

        //when
        DonationModel donationModel = donationMapper.from(donationEntity);

        //then

        Assertions.assertNotNull(donationModel , "Is null");

    }
}