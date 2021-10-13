package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity getById (Long id);
}
