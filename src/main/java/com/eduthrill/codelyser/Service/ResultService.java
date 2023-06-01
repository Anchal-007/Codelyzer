package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Entity.Result;
import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Model.ResultModel;

import java.util.List;
public interface ResultService {

    public Result addResult(ResultModel result);
    public List<ResultModel> getAllResult();
    public List<ResultModel> getResultOfQuiz(Quiz quiz);
    public List<ResultModel> getResultOfUser(User user);
    public List<ResultModel> getResultOfUserAndQuiz(Quiz quiz, User user);
}
