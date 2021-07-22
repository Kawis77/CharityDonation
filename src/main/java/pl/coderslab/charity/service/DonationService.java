package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.dao.repository.DonationRepository;
import pl.coderslab.charity.service.mapper.DonationMapper;
import pl.coderslab.charity.web.model.DonationModel;

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

}
