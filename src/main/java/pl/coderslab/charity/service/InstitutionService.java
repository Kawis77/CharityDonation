package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.dao.entity.InstitutionEntity;
import pl.coderslab.charity.dao.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<InstitutionEntity> allInstitution(){
        return institutionRepository.findAll();

    }

    public InstitutionEntity getById(Long id){
        return institutionRepository.getById(id);
    }
}
