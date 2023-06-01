package com.eduthrill.codelyser.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduthrill.codelyser.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
