package com.eduthrill.codelyser.Controller;

import com.eduthrill.codelyser.Entity.*;
import com.eduthrill.codelyser.Model.QuestionsModel;
import com.eduthrill.codelyser.Repository.*;
import com.eduthrill.codelyser.Service.QuestionService;
import com.eduthrill.codelyser.Service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRepository resultRepository;
//    @Autowired
//    private AttemptedQuizRepository attemptedQuizRepository;
//    @Autowired
//    private QuizQuestionRepository quizQuestionRepository;
//
//    @Autowired
//    private QuizResponseRepository quizResponseRepository;

    @PostMapping("/addQuestion")
    private ResponseEntity<Questions> saveQuestion(@RequestBody QuestionsModel question){
        return ResponseEntity.ok().body(this.questionService.createQuestions(question));
    }
    @CrossOrigin
    @GetMapping("/getQuestions")
    private ResponseEntity<List<QuestionsModel>> getQuestions(){
        return ResponseEntity.ok().body(this.questionService.getQuestions());
    }

    @GetMapping("/getRandomQuestions/{numberOfQuestions}/{quiz_id}")
    private ResponseEntity<List<QuestionsModel>> getRandomQuestions(@PathVariable int numberOfQuestions, @PathVariable long quiz_id){
        return ResponseEntity.ok().body(this.questionService.getRandomQuestions(numberOfQuestions,quiz_id));
    }
    @DeleteMapping("/delete/question/{question_id}")
    public void deleteQuestion(@PathVariable("question_id") Long question_id)
    {
        System.out.print(question_id);
        this.questionService.deleteQuestion(question_id);
    }
    @PutMapping("/update/question/{question_id}")
    private ResponseEntity<Questions> updateQuestion(@PathVariable Long question_id, @RequestBody QuestionsModel question) {
        question.setQuestion_id(question_id);
        return ResponseEntity.ok().body(this.questionService.updateQuestion(question));
    }
    @GetMapping("/getQuestionByQuizId/{quizId}")
    public ResponseEntity<?> getAllQuestion(@PathVariable("quizId") Long quizId) throws Exception{
        Quiz quiz=this.quizService.getQuizById(quizId);
        Set<Questions> question=quiz.getQuestion();
        List<Questions> listOfQuestions=new ArrayList<>(question);
        if(listOfQuestions.size()>Integer.parseInt(String.valueOf(quiz.getNumber_of_questions()))) {
            listOfQuestions=listOfQuestions.subList(0,Integer.parseInt(String.valueOf(quiz.getNumber_of_questions()))+1);
//            Quiz quiz1=this.questionService.getQuestionsByQuizId();
        }

        return ResponseEntity.ok(listOfQuestions);
    }
    @GetMapping("/getQuestionById/{quesId}")
    public QuestionsModel getQuestion(@PathVariable("quesId") Long question_id) throws Exception {
//        Questions question=this.questionService.getQuestionById(question_id);
//        System.out.println("Question content is:"+question.getQuestion());
        return this.questionService.getQuestionById(question_id);
    }
    @PostMapping("/evaluate-quiz")
    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Questions> questions) {
        System.out.println(questions);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        int user_id = 0;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User theUser = this.userRepository.findByUsername(username);
//        AttemptedQuiz attemptedQuiz = new AttemptedQuiz();
//        attemptedQuiz.setUsername(username);
        Result result = new Result();
        result.setUsername(username);
//        attemptedQuizRepository.save(attemptedQuiz);
        Integer correctAnswers = 0;
        double marksObtained = 0;
        Integer attempted = 0;
        Quiz quiz = null;
        for (Questions theQues : questions) {
            try {
                QuestionsModel question = this.questionService.getQuestionById(theQues.getQuestion_id());
                if (theQues.getGivenAnswer().trim().equals(question.getAnswer().trim())) {
                    correctAnswers = correctAnswers + 1;
                    attempted = attempted + 1;
                } else {
                    attempted = attempted + 1;
                }
                double marksObtainedPerQuestion = Double.parseDouble(String.valueOf(questions.get(0).getQuiz().getTotal_marks())) / questions.size();
                marksObtained = correctAnswers * marksObtainedPerQuestion;


            } catch (Exception e) {
                e.printStackTrace();
            }
            quiz = questions.get(0).getQuiz();

//            QuizQuestion quizQuestion = new QuizQuestion();
//            quizQuestion.setQuestion_id(theQues.getQuestion_id());
//            quizQuestion.setAnswer(theQues.getAnswer());
//            quizQuestion.setContent(theQues.getQuestion());
//            quizQuestion.setQuizId(theQues.getQuiz().getQuiz_id());
//            quizQuestion.setGivenAnswer(theQues.getGivenAnswer());
//            quizQuestion.setOption1(theQues.getOption_1());
//            quizQuestion.setOption2(theQues.getOption_2());
//            quizQuestion.setOption3(theQues.getOption_3());
//            quizQuestion.setOption4(theQues.getOption_4());
//            quizQuestion.setAttemptedQuiz(attemptedQuiz);
//            quizQuestionRepository.save(quizQuestion);


        }

//        QuizResponse result=new QuizResponse();
        result.setQuestions_attempted(attempted);
        result.setCorrect_answers(correctAnswers);
        result.setMarks_scored(marksObtained);
//        result.setTotal_questions(quiz.getNumber_of_questions());
        result.setQuiz(quiz);
        result.setUser(theUser);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        result.setSubmit_date_time(dtf.format(now));

        resultRepository.save(result);
//        result.setCorrectAnswers(correctAnswers);
//        result.setAttempted(attempted);
//        result.setMarksObtained(marksObtained);
////        result.setQuestions(questions);
//        result.setAttemptedQuizId(attemptedQuiz.getId());
//        quizResponseRepository.save(result);
        return ResponseEntity.ok(result);
    }
}
