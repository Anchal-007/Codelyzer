import { Component,OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit{
  
  quizzes:any;
  quizId:any;
  quizTitle=" ";
  category_id=0;
  quiz:any={
    quiz_id:0,active_status:false,date:'',end_date:'',numberOfQuestions:'',title:'',maxMarks:"",category:{cid:'',},
  }
  constructor(private router:Router,private route:ActivatedRoute,private quizService:QuizService) { }
  category:any=[
    {
      "category_id":0,"title":"","description":""
    }
  ]
  ngOnInit() {
    this.route.params.subscribe(
      (params)=>{
        this.quizId=params['quiz_id'];
        console.log(this.quizId);
        this.quizTitle=params['title'];
      }
    )
    this.quizService.getAllQuizzes().subscribe((data: any)=>this.quizzes=data)
    console.log(this.quizzes);
  }
  sendQuizDetails(quiz_id:any,title:any){
    let titleInRoute: String= title.split(' ').join('-');
     this.router.navigate(['/admin/view-questions',quiz_id, titleInRoute]);
   }
  //  addMoreQuestion(quiz_id:any,title:any){
  //   let titleroute: String= title.split(' ').join('-');
  //   this.router.navigate(['/admin/add-question',quiz_id, titleroute]);
  //  }
}

