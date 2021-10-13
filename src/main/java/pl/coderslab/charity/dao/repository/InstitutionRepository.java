package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.InstitutionEntity;

public interface InstitutionRepository extends JpaRepository <InstitutionEntity, Long> {

    InstitutionEntity getById(Long id);
}
