package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.DonationEntity;
import pl.coderslab.charity.web.model.DonationModel;

public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    void deleteById(DonationModel donationModel1);

}
