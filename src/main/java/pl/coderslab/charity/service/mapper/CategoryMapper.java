package pl.coderslab.charity.service.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.dao.entity.CategoryEntity;
import pl.coderslab.charity.web.model.CategoryModel;
@Component
public class CategoryMapper {

    public CategoryEntity from(CategoryModel categoryModel) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryModel.getId());
        categoryEntity.setName(categoryModel.getName());
        return categoryEntity;
    }

    public CategoryModel from(CategoryEntity categoryEntity) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryEntity.getId());
        categoryModel.setName(categoryEntity.getName());
        return categoryModel;
    }

}
