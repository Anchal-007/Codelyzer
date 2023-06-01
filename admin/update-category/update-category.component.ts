import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent {
  category:any={
    "title":"","description":""
  }
  category_id:any;
  constructor(private categoryService:CategoryService,private snakebar:MatSnackBar,private router:Router,private route:ActivatedRoute){}
  ngOnInit():void{
     this.category_id=this.route.snapshot.paramMap.get('category_id')
    console.log(this.category_id)
    this.categoryService.getCategory(this.category_id).subscribe((data)=>{
      this.category=data;
      console.log(this.category)
    })
  }
  updateCategory(){
    if(this.category.title==null||this.category.title.trim()==''){
      this.snakebar.open("title can't be empty","ok",{duration:3000});
      return;
   }
   if(this.category.description==null||this.category.description.trim()==''){
     this.snakebar.open("description can't be empty","ok",{duration:3000});
     return;
  }
    this.categoryService.updateCategory(this.category,this.category_id).subscribe(
      (data)=>{  })
      this.snakebar.open("success!!","category is successfully updated",{duration:3000});
  this.router.navigate(['admin/categories']);
    }
  }