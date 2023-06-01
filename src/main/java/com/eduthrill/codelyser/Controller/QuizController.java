package com.eduthrill.codelyser.Controller;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Model.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eduthrill.codelyser.Service.QuizService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/quiz/addQuiz")
    private ResponseEntity<Quiz> saveQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok().body(this.quizService.createQuiz(quiz));
    }

    @DeleteMapping("/quiz/delete/{quizid}")
    public void deleteUser(@PathVariable("quizid") Long quizId) {
        this.quizService.deleteQuiz(quizId);
    }

    @PutMapping("/updateQuiz/{quiz_id}")
    private ResponseEntity<Quiz> updateQuiz(@PathVariable Long quiz_id, @RequestBody Quiz quiz) {
        quiz.setQuiz_id(quiz_id);
        return ResponseEntity.ok().body(this.quizService.updateQuiz(quiz));

    }
    @GetMapping("/getAllQuizzes")
    public ResponseEntity<?> getAllQuizzes() throws Exception{
        List<Quiz> quizzes=this.quizService.getAllQuizzes();
        if(quizzes==null) {
            throw new Exception("there is no quiz in the database");
        }
        return ResponseEntity.ok(quizzes);
    }
    @GetMapping("/getQuizById/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long qid) throws Exception {
//        Quiz quiz=this.quizService.getQuizById(qid);
//        if(quiz==null) {
//            throw new Exception("Quiz not found exception");
//        }
        return this.quizService.getQuizById(qid);
    }

    @GetMapping("/Bycategory/{category_id}")
    public ResponseEntity<?> getQuizzesByCategoryId(@PathVariable("category_id") Long category_id){
        Category category=new Category();
        category.setCategory_id(category_id);
        return ResponseEntity.ok(this.quizService.findQuizzesByCategoryId(category));
    }

    @GetMapping("/active")
    public ResponseEntity<?> getAllActiveQuizzes(){
        return ResponseEntity.ok(this.quizService.findAllActiveQuiz());
    }

    @GetMapping("/category/active/{category_id}")
    public ResponseEntity<?> getAllActiveQuizzesOfCategory(@PathVariable("category_id") Long category_id){
        Category category=new Category();
        category.setCategory_id(category_id);
        return ResponseEntity.ok(this.quizService.findAllActiveQuizOfCategory(category));
    }

    @GetMapping("/getActiveQuizById/{quiz_id}")
    public Quiz getActiveQuizByQuizId(@PathVariable("quiz_id") Long qid) throws Exception {
        return this.quizService.getQuizActiveById(qid);
    }
}