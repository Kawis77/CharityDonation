package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.DonationEntity;

public interface DonationRepository extends JpaRepository<DonationEntity, Long> {
}
