package pl.coderslab.charity.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.DonationRepository;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DonationServiceTest {

    @Mock   //
    private DonationRepository donationRepository;

    @MockBean
    private DonationService donationService;



    private final List<DonationEntity> donationEntities = new ArrayList<>();

    public void setup(){
        DonationEntity donationEntity1 = new DonationEntity();
        donationEntity1.setId(99L);
        donationEntity1.setQuantity(20);
        donationEntities.add(donationEntity1);

        DonationEntity donationEntity2 = new DonationEntity();
        donationEntity2.setId(98L);
        donationEntity2.setQuantity(12);
        Mockito.when(donationRepository.findAll()).thenReturn(donationEntities);
    }

    @Test
    void givenDonationServiceWhenCreateThenDonationInDB() {
        //given
        DonationMapper donationMapper = new DonationMapper();
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(1L);
        donationEntity.setZipCode("22");
        donationEntity.setPickUpComment("asdasd");
        donationEntity.setStreet("xxxx");
        donationEntity.setPckUpDate("20-12-2020");
        donationEntity.setPickUpTime("20:34");

        //when
        DonationModel donationModel1 = donationMapper.from(donationEntity);
        DonationModel donationModel = donationService.create(donationModel1);

        //then
        Assertions.assertNotNull(donationModel, "Is not null");

    }

    @Test
    void givenDonationServiceWhenDeleteThenDonationIsNullInDB() {

        //given
//        DonationEntity donationEntity = new DonationEntity();
        final DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(1L);
        Mockito.when(donationRepository.findById(1L)).thenReturn(java.util.Optional.of(donationEntity)).thenReturn(null);

        //when
//        donationService.removeDonation(donationEntity);

        //then
        Mockito.verify(donationRepository, Mockito.times(1)).delete(donationEntity);
//        Assertions.assertNull(donationEntity, "Is not null");
    }

    @Test
    public void testListProducts() {
        List<DonationEntity> donationEntitiesList = donationService.allDonation();
        Assertions.assertEquals(0,donationEntitiesList.size() ,"Bląd");
    }

}