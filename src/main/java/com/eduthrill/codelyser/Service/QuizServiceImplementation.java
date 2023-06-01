package com.eduthrill.codelyser.Service;

import javax.transaction.Transactional;


import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Exception.UserNotFoundException;
import com.eduthrill.codelyser.Exception.UserWithSameUserNameException;

import com.eduthrill.codelyser.DTO.QuizDTO;

import com.eduthrill.codelyser.Model.QuizModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Repository.QuizRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class QuizServiceImplementation implements QuizService {
	@Autowired
	private QuizRepository quizRepository;

//	@Autowired
//	private QuizDTO quizDTO;
	@Override
	public Quiz createQuiz(Quiz quiz) {
//		Quiz quizEntity = quizDTO.modelToEntity(quiz);
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
//		Quiz quizEntity = quizDTO.modelToEntity(quiz);
        Optional<Quiz> q = this.quizRepository.findById(quiz.getQuiz_id());
        if (q.isPresent()) {
			Quiz quizUpdate = q.get();
			quizUpdate.setDate(quiz.getDate());
			quizUpdate.setCategory(quiz.getCategory());
			quizUpdate.setActive(quiz.isActive());
			quizUpdate.setTitle(quiz.getTitle());
			quizUpdate.setEnd_date(quiz.getEnd_date());
			quizUpdate.setNumber_of_questions(quiz.getNumber_of_questions());
			quizUpdate.setTotal_marks(quiz.getTotal_marks());
			return this.quizRepository.save(quizUpdate);
        }
		else{
			throw new UserWithSameUserNameException("quiz id not found");
		}

    }

	@Override
	public void deleteQuiz(Long quizId) {
		this.quizRepository.deleteById(quizId);
	}

	@Override
	public Quiz getQuizById(Long quizId) {
		Quiz quiz=this.quizRepository.findById(quizId).get();
		System.out.println("quiz data fetch from db is "+quiz.getTitle()+" "+quiz.getDate()+" "+quiz.getQuiz_id()+" "+quiz.getEnd_date()+" "+quiz.getCategory()+" "+quiz.getNumber_of_questions()+" "+quiz.getTotal_marks()+" "+quiz.isActive());
		return quiz;
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		return this.quizRepository.findAll();
	}
	@Override
	public List<Quiz> findQuizzesByCategoryId(Category category) {
		List<Quiz> listOfQuizzesByCategory=this.quizRepository.findQuizzesByCategory(category);
		System.out.println(listOfQuizzesByCategory);
		return this.quizRepository.findQuizzesByCategory(category);
	}

	@Override
	public List<Quiz> findAllActiveQuiz() {
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> findAllActiveQuizOfCategory(Category category) {
		return this.quizRepository.findByCategoryAndActive(category, true);
	}

	@Override
	public Quiz getQuizActiveById(Long quizId) throws Exception{
		Quiz quiz=this.quizRepository.findById(quizId).get();
		if (quiz.isActive()){
			return quiz;
		}
		else throw new UserNotFoundException("quiz id is not active");
	}




}
