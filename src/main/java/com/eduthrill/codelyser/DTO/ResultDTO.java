package com.eduthrill.codelyser.DTO;

import com.eduthrill.codelyser.Entity.Result;
import com.eduthrill.codelyser.Model.ResultModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultDTO {

    public Result modelToEntity(ResultModel resultModel){
        ModelMapper mapper =new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Result resultEntity = mapper.map(resultModel, Result.class);
        return resultEntity;
    }

    public ResultModel entityToModel( Result resultEntity){
        ModelMapper mapper =new ModelMapper();
        ResultModel resultModel = mapper.map(resultEntity, ResultModel.class);
        return resultModel;
    }

    public List<ResultModel> allEntitiesToModels (List<Result> resultEntities){
        return resultEntities.stream().map(this::entityToModel).collect(Collectors.toList());
    }
}
