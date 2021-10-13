package pl.coderslab.charity.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.web.model.DonationModel;

class DonationMapperTest {

    @Test
    void givenMapperAndModel_whenFrom_thenEntityIsNotNull() {
        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationModel donationModel = new DonationModel();
        donationModel.setId(1L);
        donationModel.setCity("Warszawa");
        donationModel.setStreet("Nadodrzanska");
        donationModel.setQuantity(20);
        donationModel.setPickUpComment("Jest ok");


        //when
        DonationEntity donationEntity = donationMapper.from(donationModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(donationEntity, "DonationEntity is null"),
                () -> Assertions.assertNotNull(donationEntity.getId(), "Id is null"),
                () -> Assertions.assertNotNull(donationEntity.getCity(), "City is null"),
                () -> Assertions.assertNotNull(donationEntity.getStreet(), "Street is null"),
                () -> Assertions.assertNotNull(donationEntity.getQuantity(), "Quantity is null"),
                () -> Assertions.assertNotNull(donationEntity.getPickUpComment(), "PickUpComment is null")

        );
    }

    @Test
    void givenMapperAndEntity_whenFrom_thenModelIsNotNull() {

        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(1L);
        donationEntity.setCity("Warszawa");
        donationEntity.setStreet("Nadodrzanska");
        donationEntity.setQuantity(20);
        donationEntity.setPickUpComment("Jest ok");


        //when`
        DonationModel donationModel = donationMapper.from(donationEntity);

        //then

        Assertions.assertAll(
                () -> Assertions.assertNotNull(donationModel, "DonationEntity is null"),
                () -> Assertions.assertNotNull(donationModel.getId(), "Id is null"),
                () -> Assertions.assertNotNull(donationModel.getCity(), "City is null"),
                () -> Assertions.assertNotNull(donationModel.getStreet(), "Street is null"),
                () -> Assertions.assertNotNull(donationModel.getQuantity(), "Quantity is null"),
                () -> Assertions.assertNotNull(donationModel.getPickUpComment(), "PickUpComment is null")
        );

    }

}