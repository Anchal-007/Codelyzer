import { Component } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent {

  quizId:any;
  quizTitle:any;
  questions={
    question:'',option_1:'',option_2:'',option_3:'',option_4:'',answer:'',quiz:{quiz_id:''},
  }
  // option{{i}}
  constructor(private Route:Router,private router:ActivatedRoute,private questionService:QuestionService,private snackbar:MatSnackBar) { }
  ngOnInit(): void {
    this.quizId=this.router.snapshot.paramMap.get("quiz_id");
    this.quizTitle=this.router.snapshot.paramMap.get("title");
    this.quizTitle=this.quizTitle.split('-').join(" ");
    console.log("title of the quiz is "+this.quizTitle+" quiz id is "+this.quizId);
  }
  addQuestion(){
    console.log("data of question to be added is:"+this.questions);
    this.questions.quiz.quiz_id=this.quizId;
    this.questionService.addQuestion(this.questions).subscribe(
      (data:any)=>{
        //console.log(data);
        this.snackbar.open("success!!","question is successfully added");
        this.Route.navigate(['/admin/view-questions',this.quizId,this.quizTitle]);
      },
      // (error)=>{
      //  // console.log(error);
      //  this.snackbar.open("err!!","question can't be added try again!!");
      // }
    )
  }
}
