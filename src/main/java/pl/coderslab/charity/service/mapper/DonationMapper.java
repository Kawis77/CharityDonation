package pl.coderslab.charity.service.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.web.model.DonationModel;

@Component
public class DonationMapper {

    public DonationEntity from(DonationModel donationModel){
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(donationModel.getId());
        donationEntity.setCity(donationModel.getCity());
        donationEntity.setStreet(donationModel.getStreet());
        return donationEntity;
    }
}
