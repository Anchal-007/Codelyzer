package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Model.CategoryModel;

import java.util.List;

public interface CategoryService {
	Category createCategory(CategoryModel categoryModel) ;

	Category getCategoryById(Long category_id);

	void deleteCategory(Long category_id);
	public List<CategoryModel> getCategories();


	Category updateCategory(CategoryModel category);

}
