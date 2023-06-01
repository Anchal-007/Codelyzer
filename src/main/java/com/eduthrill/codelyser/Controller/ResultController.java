package com.eduthrill.codelyser.Controller;


import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Model.ResultModel;
import com.eduthrill.codelyser.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping("/add")
    public ResponseEntity<?> addResult(@RequestBody ResultModel result){
        return ResponseEntity.ok(this.resultService.addResult(result));
    }

    @GetMapping("/get/{qid}/{uid}")
    public ResponseEntity<?> getResultByUserAndQuiz(@PathVariable("qid") long qid, @PathVariable("uid") long uid){

        Quiz quiz1 = new Quiz();
        quiz1.setQuiz_id(qid);
        User user1 = new User();
        user1.setUser_id(uid);

        List<ResultModel> lis = this.resultService.getResultOfUserAndQuiz(quiz1, user1);
        return ResponseEntity.ok(lis);

    }

    @GetMapping("/getQuizResult/{qid}")
    public ResponseEntity<?> getResultByQuiz(@PathVariable("qid") long qid){
        Quiz quiz1 = new Quiz();
        quiz1.setQuiz_id(qid);

        List<ResultModel> lis = this.resultService.getResultOfQuiz(quiz1);
        return ResponseEntity.ok(lis);
    }

    @GetMapping("/getUserResult/{uid}")
    public ResponseEntity<?> getResultByUser(@PathVariable("uid") long uid){
        User user1 = new User();
        user1.setUser_id(uid);

        List<ResultModel> lis = this.resultService.getResultOfUser(user1);
        return ResponseEntity.ok(lis);

    }

}
