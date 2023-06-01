package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.Questions;
import com.eduthrill.codelyser.Model.QuestionsModel;

import java.util.List;

public interface QuestionService {
    Questions createQuestions(QuestionsModel questions);

    Questions updateQuestion(QuestionsModel questions);
    List<QuestionsModel> getQuestions();
    void deleteQuestion(Long category_id);

    QuestionsModel getQuestionById(Long question_id) throws Exception;

    List<QuestionsModel> getRandomQuestions(int numberOfQuestions, long quiz_id);
}
