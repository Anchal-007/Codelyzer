import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http:HttpClient) { }

  public getAllQuizzes():Observable<any>{
    return this.http.get<any>(`${baseUrl}/getAllQuizzes`);
  }


  public addQuiz(quizzes:any):Observable<any>{
    // console.log(quizzes);
    return this.http.post<any>(`${baseUrl}/quiz/addQuiz`,quizzes);
  }

   public updatetheQuiz(quiz:any,quiz_id:number){
    return this.http.put<any>(`${baseUrl}/updateQuiz/${quiz_id}`,quiz);
  
  }
 
  public getQuiz(quiz_id:any){
    return this.http.get(`${baseUrl}/getQuizById/${quiz_id}`);
  }
 
  public deleteQuiz(qid:any){
    return this.http.delete(`${baseUrl}/quiz/${qid}`);
  }

  public getAllActiveQuiz(){
    return this.http.get(`${baseUrl}/active`);
  }

  public getAllActiveQuizOfCategory(category_id:any){
    return this.http.get(`${baseUrl}/category/active/${category_id}`);
  }  

  public getAllQuizzesByCategory(category_id:any){
    return this.http.get(`${baseUrl}/Bycategory/${category_id}`);
  }

  public getActiveQuiz(quiz_id:any){
    return this.http.get(`${baseUrl}/getActiveQuizById/${quiz_id}`);
  }

}


