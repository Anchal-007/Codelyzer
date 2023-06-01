package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.DTO.CategoryDTO;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Exception.UserWithSameUserNameException;

import com.eduthrill.codelyser.Model.CategoryModel;
import com.eduthrill.codelyser.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {
		@Autowired
		private CategoryRepository categoryRepository;
		@Autowired
		private CategoryDTO categoryDTO;
	   @Override
	    public Category createCategory(CategoryModel categoryModel){
		   Category categoryEntity = categoryDTO.modelToEntity(categoryModel);
		   return categoryRepository.save(categoryEntity);

	   }

		@Override
		public Category getCategoryById(Long category_id) {

				Category category =this.categoryRepository.findById(category_id).get();
				System.out.println("category data fetch from db is "+ category.getTitle()+" "+ category.getDescription()+" "+ category.getCategory_id());
				return category;
		}

		@Override
			public void deleteCategory(Long category_id) {
				this.categoryRepository.deleteById(category_id);
			}

		@Override
		public List<CategoryModel> getCategories() {
			return categoryDTO.allEntitiesToModels(this.categoryRepository.findAll());
		}

	@Override
	public Category updateCategory(CategoryModel category) {
		Category categories = categoryDTO.modelToEntity(category);
		Optional<Category> category1 = this.categoryRepository.findById(categories.getCategory_id());
		if (category1.isPresent()) {
			Category categoryUpdate = category1.get();
			categoryUpdate.setDescription(categories.getDescription());
			categoryUpdate.setTitle(categories.getTitle());
			categoryUpdate.setQuizzes(categories.getQuizzes());
			return this.categoryRepository.save(categoryUpdate);
		} else {
			throw new UserWithSameUserNameException("catgory not found");
//			System.out.print("not found");
		}

	}


//	@Override
//	public Category updateCategory(CategoryModel category) {
//		Category categories = categoryDTO.modelToEntity(category);
//		Optional<Category> category1 = this.categoryRepository.findById(categories.getCategory_id());
//		if (category1.isPresent()){
//			Category categoryUpdate=category1.get();
//			categoryUpdate.setDescription(categories.getDescription());
//			categoryUpdate.setTitle(categories.getTitle());
//			categoryUpdate.setQuizzes(categories.getQuizzes());
//			return this.categoryRepository.save(categoryUpdate);
//		}
//		else{
//			throw new UserWithSameUserNameException("catgory not dound");
//		}
//	}


}
