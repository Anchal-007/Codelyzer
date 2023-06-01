import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { MatSnackBar } from '@angular/material/snack-bar';
 
@Component({
  selector: 'app-view-category',
  templateUrl: './view-category.component.html',
  styleUrls: ['./view-category.component.css']
})
export class ViewCategoryComponent {
  category:any=[{
    "category_id":"","title":"","description":"","quizzes":{"quiz_id":""}
  }]
 
  constructor(private categoryService:CategoryService,private router:Router,private route:ActivatedRoute,private snakebar:MatSnackBar){}
  ngOnInit(){
    this.categoryService.getAllCategory().subscribe((data: any)=>this.category=data)
    console.log(this.category);
  }
  deleteCategory(cid:number){
    this.categoryService.deleteCategory(cid).subscribe((data)=>console.log("deleted successfully cid:"+cid))
    this.snakebar.open("success!!","category is successfully deleted",{duration:3000});
  }
 
}
