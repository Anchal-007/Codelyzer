package com.eduthrill.codelyser.Repository;

import com.eduthrill.codelyser.Entity.Questions;
import com.eduthrill.codelyser.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Long> {
    Set<Questions> findByQuiz(Quiz quiz);
    Set<Questions> findByLevel(String level);
}
