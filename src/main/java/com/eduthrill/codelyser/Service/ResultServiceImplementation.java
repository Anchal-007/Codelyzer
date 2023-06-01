package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.DTO.ResultDTO;
import com.eduthrill.codelyser.Exception.ResultException;
import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Entity.Result;
import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Model.ResultModel;
import com.eduthrill.codelyser.Repository.ResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ResultServiceImplementation implements ResultService{

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ResultDTO resultDTO;
    @Override
    public Result addResult(ResultModel result){
        Result resultEntity = resultDTO.modelToEntity(result);
        return this.resultRepository.save(resultEntity);
    }
    @Override
    public List<ResultModel> getAllResult(){
        return resultDTO.allEntitiesToModels(this.resultRepository.findAll());
    }
    @Override
    public List<ResultModel> getResultOfQuiz(Quiz quiz){
        Optional<List<Result>> resultObj = Optional.ofNullable(this.resultRepository.findByQuiz(quiz));
        if(resultObj.isPresent()){
            log.trace("Checking for results");
            log.info("Result found !!");
            return resultDTO.allEntitiesToModels(resultObj.get());
        }
        else
            throw new ResultException("Result didn't found for quiz_id: " + quiz.getQuiz_id());
    }
    @Override
    public List<ResultModel> getResultOfUser(User user){
        log.trace("Checking for results");
        Optional<List<Result>> resultObj = Optional.ofNullable(this.resultRepository.findByUser(user));
        if(resultObj.isPresent()){
            log.info("Result found !!");
            return resultDTO.allEntitiesToModels(resultObj.get());
        }
        else
            throw new ResultException("Result didn't found for user_id:" + user.getUser_id());
    }
    @Override
    public List<ResultModel> getResultOfUserAndQuiz(Quiz quiz, User user){
        log.trace("Checking for results");
        Optional<List<Result>> resultObj = Optional.ofNullable(this.resultRepository.findByQuizAndUser(quiz, user));
        if(resultObj.isPresent()){
            log.info("Result found !!");
            return resultDTO.allEntitiesToModels(resultObj.get());
        }
        else
            throw new ResultException("Result didn't found for quiz_id: " + quiz.getQuiz_id() + " and user_id:" + user.getUser_id());

    }
}
