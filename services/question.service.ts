import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }
  public getAllQuestions(quesId:any):Observable<any>{
    return this.http.get<any>(`${baseUrl}/getQuestions`);
 }
 public getQuestionsOfQuiz(quiz_id:any):Observable<any>{
  return this.http.get<any>(`${baseUrl}/getQuestionByQuizId/${quiz_id}`);
}
public getQuestion(quesId:any){
  return this.http.get(`${baseUrl}/update/question/${quesId}`);
}
public evaluateQuiz(question:any){
  return this.http.post(`${baseUrl}/question/evaluate-quiz`,question);
}
public addQuestion(question: any){
  return this.http.post(`${baseUrl}/question`,question);
}
}
