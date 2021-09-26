package pl.coderslab.charity.service;



import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.DonationRepository;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DonationService {
    private static final Logger LOGGER = Logger.getLogger(DonationService.class.getName());

    private final DonationRepository donationRepository;
    private final DonationMapper donationMapper;

    public DonationService(DonationRepository donationRepository, DonationMapper donationMapper) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
    }


    public DonationModel create(DonationModel donationModel) {
        LOGGER.info("create(" + donationModel + ")");
        DonationEntity donationEntity = donationMapper.from(donationModel);
        DonationEntity savedDonationEntity = donationRepository.save(donationEntity);
        DonationModel savedDonationModel = donationMapper.from(savedDonationEntity);
        return savedDonationModel;
    }

    public Long count(DonationModel donationModel) {
        LOGGER.info("Count donation");
        Long count = donationRepository.sumQuantities();
        return count;

    }

    public List<DonationEntity> allDonation() {
        LOGGER.info("Find All Donation");
        return donationRepository.findAll();
    }

    public Long sumQuantity() {
        LOGGER.info("Count quantity");
        return donationRepository.sumQuantities();
//        Integer count = 0;
//        for (DonationEntity donationEntity : allDonation()){
//            count += donationEntity.getQuantity();
//
//        }
//        return  count;
//    }

    }

    public Optional<DonationEntity> findDonationById(Long id) {
        LOGGER.info("find Donation by Id ()");
        return donationRepository.findById(id);

    }

    public void removeDonation(DonationEntity donationEntity) {
        donationRepository.delete(donationEntity);

    }
}
