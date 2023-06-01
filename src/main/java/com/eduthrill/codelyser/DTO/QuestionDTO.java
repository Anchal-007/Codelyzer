package com.eduthrill.codelyser.DTO;

import com.eduthrill.codelyser.Entity.Questions;
import com.eduthrill.codelyser.Model.QuestionsModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionDTO {
    public Questions modelToEntity(QuestionsModel questionsModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Questions questionsEntity = mapper.map(questionsModel, Questions.class);
        return questionsEntity;
    }

    public QuestionsModel entityToModel( Questions questionsEntity){
        ModelMapper mapper =new ModelMapper();
        QuestionsModel questionsModel = mapper.map(questionsEntity, QuestionsModel.class);
        return questionsModel;
    }

    public List<QuestionsModel> allEntitiesToModels (List<Questions> questionsEntities){
        return questionsEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }
}
