import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {
 
  category:any=[
    {
      "category_id":0,"title":"","description":""
    }
  ]

  quizId:any;
  

  quiz:any={
    quiz_id:0,active_status:false,date:'',end_date:'',number_of_questions:'',title:'',total_marks:"",category:{category_id:'',},
  }
  constructor(private categoryService:CategoryService,private quizService:QuizService,private snakebar:MatSnackBar,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params)=>{
        this.quizId=params['quiz_id'];
        console.log("id of the quiz is "+this.quizId);
     
      }
    )
    this.quizService.getQuiz(this.quizId).subscribe((data)=>{
      this.quiz=data;
      console.log(this.quiz)
    })
   
  }

  updateQuiz(){

   // console.log("quiz data send from front-end is: "+this.quiz);
   console.log("title data send from front-end is: "+this.quiz.title);
   if(this.quiz.title==null||this.quiz.title==''){
       this.snakebar.open("Invalid data!! quiz title can't be empty or null");
       return;
   }
   if(this.quiz.category.description==null||this.quiz.category.description==''){
     this.snakebar.open("Invalid data!! quiz description can't be empty or null");
     return;
   }
   console.log("start date data send from front-end is: "+this.quiz.date);
   if(this.quiz.date==null||this.quiz.date==''){
     this.snakebar.open("Invalid data!! start date can't be empty or null");
     return;
   }
   console.log("end date data send from front-end is: "+this.quiz.end_date);
   if(this.quiz.end_date==null||this.quiz.end_date==''){
     this.snakebar.open("Invalid data!! start date can't be empty or null");
     return;
   }
   console.log("maxmarks data send from front-end is: "+this.quiz.total_marks);
   if(this.quiz.total_marks==null||this.quiz.total_marks==''){
      this.snakebar.open("Invalid data!! quiz maxMarks can't be empty or null");
      return;
   }
   console.log("category data send from front-end is: "+JSON.stringify(this.quiz.category));
   if(this.quiz.category==null||this.quiz.category==''){
     this.snakebar.open("Invalid data!! quiz category can't be empty or null");
     return;
  }
  console.log("number of questions data send from front-end is: "+this.quiz.number_of_questions);
   if(this.quiz.number_of_questions==null||this.quiz.number_of_questions==''){
      this.snakebar.open("Invalid data!! quiz must have limit on number of question");
      return;
     }
    // let x={quizId:this.quizId}
    //this.quizService.updatetheQuiz(x).subscribe(
    this.quizService.updatetheQuiz(this.quiz,this.quizId).subscribe(    
      (data:any)=>{
       console.log(JSON.stringify(data));
        console.log("success!!","quiz is successfully updated","success");
        // this.router.navigate(['/viewQuizzes']);
        this.router.navigate(['/admin/view-quizzes']);
      },
    
    )
  }
    
}
