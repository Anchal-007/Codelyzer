package com.eduthrill.codelyser.Repository;

import com.eduthrill.codelyser.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eduthrill.codelyser.Entity.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findQuizzesByCategory(Category category);

    List<Quiz> findByActive(boolean active);

    List<Quiz> findByCategoryAndActive(Category category, boolean active);
}
