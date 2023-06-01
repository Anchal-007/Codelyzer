package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.DTO.QuestionDTO;
import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Exception.UserWithSameUserNameException;
import com.eduthrill.codelyser.Entity.Questions;
import com.eduthrill.codelyser.Model.QuestionsModel;
import com.eduthrill.codelyser.Repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.*;

import java.util.Set;

@Service
@Transactional
public class QuestionServiceImplementation implements QuestionService{
    @Autowired
    private QuestionsRepo questionsRepo;
    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestionDTO questionDTO;
    @Override
    public Questions createQuestions(QuestionsModel questionsModel){
        Questions questions = questionDTO.modelToEntity(questionsModel);
        return this.questionsRepo.save(questions);
    }

    @Override
    public Questions updateQuestion(QuestionsModel questions) {
//        Questions questions = questionDTO.modelToEntity(questionsModel);
        Optional<Questions> que = this.questionsRepo.findById(questions.getQuestion_id());
        if (que.isPresent()) {

            Questions questionUpdate = que.get();
            questionUpdate.setQuestion(questions.getQuestion());
            questionUpdate.setAnswer(questions.getAnswer());
            questionUpdate.setOption_1(questions.getOption_1());
            questionUpdate.setOption_2(questions.getOption_2());
            questionUpdate.setOption_3(questions.getOption_3());
            questionUpdate.setOption_4(questions.getOption_4());
            questionUpdate.setOption_5(questions.getOption_5());
            questionUpdate.setOption_6(questions.getOption_6());
            questionUpdate.setOption_7(questions.getOption_7());
            questionUpdate.setOption_8(questions.getOption_8());
            questionUpdate.setOption_9(questions.getOption_9());
            questionUpdate.setOption_10(questions.getOption_10());
//            questionUpdate.setQuiz_id(questions.getQuiz_id());
            questionUpdate.setLevel(questions.getLevel());
            return this.questionsRepo.save(questionUpdate);
        }
        else{

                throw new UserWithSameUserNameException("question id not found");
            }

    }



    @Override
    public List<QuestionsModel> getQuestions(){
        return questionDTO.allEntitiesToModels(this.questionsRepo.findAll());
    }





    @Override
    public void deleteQuestion(Long question_id){
        this.questionsRepo.deleteById(question_id);
    }

    @Override
    public QuestionsModel getQuestionById(Long question_id) throws Exception {
        Questions question=this.questionsRepo.findById(question_id).get();
        if(question==null) {
            throw new Exception("Question is not found please enter valid ques id");
        }
        return questionDTO.entityToModel(question);
    }

    @Override
    public List<QuestionsModel> getRandomQuestions(int numberOfQuestions, long quiz_id) {
        Quiz quiz=this.quizService.getQuizById(quiz_id);
        Set<Questions> questions=quiz.getQuestion();
        int totalQuestions=quiz.getNumber_of_questions(); //Integer.parseInt(quiz.getNumber_of_questions());
        List list=new ArrayList(questions);
        List easyList=new ArrayList(questions);
        List mediumList=new ArrayList(questions);
        List hardList=new ArrayList(questions);
        if(list.size()>totalQuestions)
        {
            list=list.subList(0,totalQuestions+1);
        }
        Collections.shuffle(list);
        for(int i=0;i<list.size();i++){
            Questions lists= (Questions) list.get(i);
            String value=lists.getLevel();
            if (value=="easy"){
                easyList.add(lists);
            }
            else if(value=="medium"){
                mediumList.add(lists);
            }
            else{
                hardList.add(lists);
            }

        }
        Collections.shuffle(easyList);
        Collections.shuffle(mediumList);
        Collections.shuffle(hardList);
        int easyCount= (int) (0.4*numberOfQuestions);
        int mediumCount=(int) (0.4*numberOfQuestions);
        int hardCount=(int)(0.2*numberOfQuestions);
        List<Questions> randomQuestions = new ArrayList<>();
        for(int i = 0; i < easyCount; i++) {
            randomQuestions.add((Questions) list.get(i));

        }
        for(int i = 0; i < mediumCount; i++) {
            randomQuestions.add((Questions) list.get(i));

        }
        for(int i = 0; i < hardCount; i++) {
            randomQuestions.add((Questions) list.get(i));

        }
        return questionDTO.allEntitiesToModels(randomQuestions);
    }
}