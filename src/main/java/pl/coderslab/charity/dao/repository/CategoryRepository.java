package pl.coderslab.charity.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dao.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
