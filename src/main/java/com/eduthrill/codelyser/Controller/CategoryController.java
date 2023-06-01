package com.eduthrill.codelyser.Controller;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Model.CategoryModel;
import com.eduthrill.codelyser.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	//for adding category

	 @PostMapping("/addCategory")
	    private ResponseEntity<Category> saveCategory(@RequestBody CategoryModel categoryModel){
	        return ResponseEntity.ok().body(this.categoryService.createCategory(categoryModel));
	    }

	 @DeleteMapping("/delete/{category_id}")

	    public void deleteCategory(@PathVariable("category_id") Long category_id)
	    {
	         this.categoryService.deleteCategory(category_id);
	    }


	@PutMapping("/updateCategory/{category_id}")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryModel category, @PathVariable long category_id) {
		category.setCategory_id(category_id);
		return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
	}


	@GetMapping("/getCategory/{category_id}")

	public ResponseEntity<Category> getCategory(@PathVariable("category_id") Long category_id) throws Exception {
		System.out.println("Category id requested from the user is "+category_id);
		Category categoryModel =this.categoryService.getCategoryById(category_id);
		if(categoryModel ==null) {
			throw new Exception("Category not found exception");
		}
		System.out.println("category data fetch from db is "+ categoryModel.getTitle()+" "+ categoryModel.getDescription()+" "+ categoryModel.getCategory_id());
		return ResponseEntity.ok(categoryModel);
	}
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<CategoryModel>> getAllCategory() throws Exception{
		List<CategoryModel> categories=this.categoryService.getCategories();

		return ResponseEntity.ok(categories);
	}
}
