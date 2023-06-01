package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Model.QuizModel;

import java.util.List;

public interface QuizService {
	public Quiz createQuiz(Quiz quiz);

	Quiz updateQuiz(Quiz quiz);

	public void deleteQuiz(Long quizId);

	Quiz getQuizById(Long quizId);

	public List<Quiz> getAllQuizzes();

	public List<Quiz> findQuizzesByCategoryId(Category category);

	public List<Quiz> findAllActiveQuiz();

	public List<Quiz> findAllActiveQuizOfCategory(Category category);

	Quiz getQuizActiveById(Long quizId) throws Exception;


}
