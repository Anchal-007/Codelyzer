package com.eduthrill.codelyser.DTO;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Model.CategoryModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDTO {

    public Category modelToEntity(CategoryModel categoryModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Category categoryEntity = mapper.map(categoryModel, Category.class);
        return categoryEntity;
    }

    public CategoryModel entityToModel(Category categoryEntity){
        ModelMapper mapper =new ModelMapper();
        CategoryModel categoryModel = mapper.map(categoryEntity, CategoryModel.class);
        return categoryModel;
    }

    public List<CategoryModel> allEntitiesToModels (List<Category> categoryEntities){
        return categoryEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }
}
