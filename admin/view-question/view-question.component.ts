import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})
export class ViewQuestionComponent implements OnInit {
  quizId:any;
  title:any;
  quizTitle=" ";
 
 questions:any=[{
   question_id:'',answer:'', question:'',option_1:'',option_2:'',option_3:'',option_4:'',option_5:'',option_6:'',option_7:'',option_8:'',option_9:'',option_10:'',quiz:{quizId:''},
 },]
 quiz:any={
  quiz_id:0,active_status:false,date:'',end_date:'',numberOfQuestions:'',title:'',maxMarks:"",category:{cid:'',},
}

 constructor(private router:Router,private route:ActivatedRoute,private questionService:QuestionService,private quizService:QuizService) { }

 ngOnInit(): void {
 
  this.route.params.subscribe(
    (params)=>{
      this.quizId=params['quiz_id'];
      console.log(this.quizId);
      this.quizTitle=params['title'];
    }
  ),
  // this.route.params.subscribe(
  //   (params)=>{
  //     this.questionId=params['question_id'];
  //     console.log("ques id is "+this.questionId);
  //     this.quizTitle=params['title'];
  //   }
  // )

 
    console.log("quiz id is"+JSON.stringify(this.quizId))
   console.log("title of the quiz is "+JSON.stringify(this.quizTitle)+" quiz id is "+JSON.stringify(this.quizId));
   this.getQuizQuestions();
 } 
 
  getQuizQuestions(){
    this.questionService.getQuestionsOfQuiz(this.quizId).subscribe((data: any)=>this.questions=data)
    console.log(this.questions);
  }
 }



 


//  sendQuestionIdwithTitle(quesId:any){
//    this.router.navigate(['/admin/update-question',quesId,this.quizTitle]);
//  }




