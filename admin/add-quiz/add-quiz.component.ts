import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import {FormBuilder } from '@angular/forms';
import { NgForm } from '@angular/forms';
import {FormGroup } from '@angular/forms';
// import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit  {
  // category:any=[
  //   {
  //     cid:'',title:'',description:''
  //   }
  // ]
  category_id:any;

  quiz:any={
    qid:0,active:false,date:'',end_date:'',number_of_questions:'',title:'', description:'',total_marks:"",category:{category_id:'',}
  }


  constructor(private quizservice:QuizService,private categoryservice:CategoryService,private snakebar:MatSnackBar,private route:Router,private router:ActivatedRoute) { }

  ngOnInit(): void {
    this.category_id=this.router.snapshot.paramMap.get("category_id");
    console.log("category id",this.category_id)
  }
  
  addQuiz(){
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
    console.log("category data send from front-end is: "+this.quiz.category.cid);
    if(this.quiz.category==null||this.quiz.category==''){
      this.snakebar.open("Invalid data!! quiz category can't be empty or null");
      return;
   }
   console.log("number of questions data send from front-end is: "+this.quiz.number_of_questions);
    if(this.quiz.number_of_questions==null||this.quiz.number_of_questions==''){
       this.snakebar.open("Invalid data!! quiz must have limit on number of question");
       return;
    }
    this.quiz.category.category_id=this.category_id
    this.quizservice.addQuiz(this.quiz).subscribe(
      (data:any)=>{
        
        console.log(JSON.stringify(data));
        console.log("success!!","quiz is successfully added","success");
        this.route.navigate(['/admin/view-quizzes']);
      }
     
   )
   
  }

}
