package com.eduthrill.codelyser.DTO;

import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Model.QuizModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuizDTO {
    public Quiz modelToEntity(QuizModel quizModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Quiz quizEntity = mapper.map(quizModel, Quiz.class);
        return quizEntity;
    }

    public QuizModel entityToModel( Quiz quizEntity){
        ModelMapper mapper =new ModelMapper();
        QuizModel quizModel = mapper.map(quizEntity, QuizModel.class);
        return quizModel;
    }

    public List<QuizModel> allEntitiesToModels (List<Quiz> quizEntities){
        return quizEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }
}
