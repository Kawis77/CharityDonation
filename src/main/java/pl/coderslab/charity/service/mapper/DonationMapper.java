package pl.coderslab.charity.service.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.DonationRepository;
import pl.coderslab.charity.web.model.DonationModel;

@Component
public class DonationMapper {

    DonationRepository donationRepository;




    public DonationEntity from(DonationModel donationModel) {
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(donationModel.getId());
        donationEntity.setQuantity(donationModel.getQuantity());
        donationEntity.setCategory(donationModel.getCategoryEntity());
        donationEntity.setInstitution(donationModel.getInstitutionEntity());
        donationEntity.setStreet(donationModel.getStreet());
        donationEntity.setCity(donationModel.getCity());
        donationEntity.setPckUpDate(donationModel.getPckUpDate());
        donationEntity.setPickUpTime(donationModel.getPickUpTime());
        donationEntity.setPickUpComment(donationModel.getPickUpComment());

        return donationEntity;
    }

    public DonationModel from(DonationEntity donationEntity) {
        DonationModel donationModel = new DonationModel();
        donationModel.setId(donationEntity.getId());
        donationModel.setQuantity(donationEntity.getQuantity());
        donationModel.setCategoryEntity(donationEntity.getCategory());
        donationModel.setInstitutionEntity(donationEntity.getInstitution());
        donationModel.setStreet(donationEntity.getStreet());
        donationModel.setCity(donationEntity.getCity());
        donationModel.setPckUpDate(donationEntity.getPckUpDate());
        donationModel.setPickUpTime(donationEntity.getPickUpTime());
        donationModel.setPickUpComment(donationEntity.getPickUpComment());
        return donationModel;

    }

    public DonationModel delete (DonationEntity donationEntity){
        DonationModel donationModel = new DonationModel();
        donationModel.setId(donationEntity.getId());
        return donationModel;

    }

}
