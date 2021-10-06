package pl.coderslab.charity.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class DonationServiceMockTest {

    @Test
    void add_Donation_Mock() {
        //given
        DonationService donationService = mock(DonationService.class);
        DonationModel donationModel = new DonationModel();
        donationModel.setStreet("ABC1");
        given(donationService.create(donationModel)).willReturn(donationModel);
//        given(donationService.create(Mockito.any(DonationModel.class))).willReturn(donationModel);

        //when
        DonationModel createdMockModel = donationService.create(donationModel);

        //when
        Assertions.assertEquals("ABC1", createdMockModel.getStreet());
    }

    @Test
    void remove_Donation_Mock() {
        //given
        DonationService donationService = mock(DonationService.class);
        DonationMapper donationMapper = new DonationMapper();
        DonationModel donationModel = new DonationModel();
        donationModel.setStreet("ABC1");
        given(donationService.create(Mockito.any(DonationModel.class))).willReturn(donationModel);

        //when
        DonationModel createdMockModel = donationService.create(new DonationModel());
        DonationEntity createdMockEntity = donationMapper.from(createdMockModel);
        donationService.removeDonation(createdMockEntity);

        //then
        Assertions.assertNull(createdMockEntity.getId(), "Id is null");

    }

    @Test
    void list_test_mock() {
        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationService donationService = mock(DonationService.class);
        DonationModel donationModel = new DonationModel();
        donationModel.setStreet("ABC");
        DonationModel donationModel2 = new DonationModel();
        donationModel2.setStreet("ABC1");
        given(donationService.create(Mockito.any(DonationModel.class))).willReturn(donationModel, donationModel2);

        //when
        DonationModel createdDonationModel = donationService.create(new DonationModel());
        DonationModel createdDonationModel2 = donationService.create(new DonationModel());
        List<DonationEntity> donationEntityList = donationService.allDonation();
        DonationEntity createdDonationEntity = donationMapper.from(createdDonationModel);
        DonationEntity createdDonationEntity2 = donationMapper.from(createdDonationModel2);
        donationEntityList.add(createdDonationEntity);
        donationEntityList.add(createdDonationEntity2);

        //then
        Assertions.assertEquals("ABC", createdDonationModel.getStreet());
        Assertions.assertEquals("ABC1", createdDonationModel2.getStreet());
        Assertions.assertEquals(2, donationEntityList.size());

    }

    @Test
    void test_sum_count_mock(){
        //given
        DonationService donationService = mock(DonationService.class);
        DonationModel donationModel = new DonationModel();
        donationModel.setQuantity(15);
        given(donationService.create(Mockito.any(DonationModel.class))).willReturn(donationModel);
        given(donationService.count()).willReturn(15L);

        //when

        DonationModel createdDonationModel = donationService.create(donationModel);
        Long sumOfQuantities = donationService.count();

        //then

        Assertions.assertEquals(15 , sumOfQuantities);
    }
}