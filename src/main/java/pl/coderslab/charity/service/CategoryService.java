package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.dao.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> allCategory() {
        return categoryRepository.findAll();

    }

    public CategoryEntity getById(Long id) {
        return categoryRepository.getById(id);
    }
}
