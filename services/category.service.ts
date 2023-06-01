import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';
 
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  
  constructor(private http: HttpClient) { }
  getAllCategory():Observable<any>{
    return this.http.get<any>(`${baseUrl}/category/getAllCategories`);
  }
 
  addCategory(category:any):Observable<any>{
    console.log(category)
    return this.http.post<any>(`${baseUrl}/category/addCategory`,category);
  }
  public deleteCategory(cid:number){
    // console.log(cid);
     return this.http.delete(`${baseUrl}/category/delete/${cid}`);
   }
   public updateCategory(category:any,category_id:number){
    return this.http.put(`${baseUrl}/category/updateCategory/${category_id}`,category);
   }
   public getCategory(cid:any){
    return this.http.get(`${baseUrl}/category/getCategory/${cid}`);
  }


}
