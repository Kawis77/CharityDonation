package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.DonationRepository;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class DonationFormService {
    private static final Logger LOGGER = Logger.getLogger(DonationFormService.class.getName());

    private final DonationRepository donationRepository;
    private final DonationMapper donationMapper;

    public DonationFormService(DonationRepository donationRepository, DonationMapper donationMapper) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
    }

    public void create(DonationModel donationModel) {
        LOGGER.info("Create model");
        DonationEntity donationEntity = donationMapper.from(donationModel);
        donationRepository.save(donationEntity);

    }

    public Long count(DonationModel donationModel) {
        LOGGER.info("Count donation");
        DonationEntity donationEntity = donationMapper.from(donationModel);
        Long count = donationRepository.count();
        return count;

    }

    public List<DonationEntity> allDonation() {
        return donationRepository.findAll();
    }

    public Integer countquantity() {
       Integer count = 0;
       for (DonationEntity donationEntity : allDonation()){
           count += donationEntity.getQuantity();

       }
       return  count;
    }

}
