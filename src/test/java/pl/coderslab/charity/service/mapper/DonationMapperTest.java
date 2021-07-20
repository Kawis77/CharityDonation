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

        //when
        DonationEntity donationEntity = donationMapper.from(donationModel);

        //then
        Assertions.assertNotNull(donationEntity, "DonationEntity is null");
    }
}