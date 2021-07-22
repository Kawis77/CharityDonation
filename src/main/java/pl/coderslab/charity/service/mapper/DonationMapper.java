package pl.coderslab.charity.service.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.web.model.DonationModel;

@Component
public class DonationMapper {

    public DonationEntity from(DonationModel donationModel) {
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(donationModel.getId());
        donationEntity.setCity(donationModel.getCity());
        donationEntity.setStreet(donationModel.getStreet());
        return donationEntity;
    }

    public DonationModel from(DonationEntity donationEntity) {
        DonationModel donationModel = new DonationModel();
        donationModel.setId(donationEntity.getId());
        donationModel.setCity(donationEntity.getCity());
        donationModel.setStreet(donationEntity.getStreet());
        return donationModel;
    }
}
//Zaimplementowac metode from , i napisac do niej test jednostkowe.