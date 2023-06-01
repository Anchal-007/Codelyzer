import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
// import Swal from 'sweetalert2';
@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent {
  category:any={
    "description":"","title":""
  }
  constructor(private categoryService:CategoryService,private router:Router,private snakebar:MatSnackBar,private route:ActivatedRoute){
    // this.categoryService.getAllCategory()
    //                     .subscribe()        
  }
 
 
  addCategory(){
    console.log(this.category)  
    if(this.category.title==null||this.category.title.trim()==''){
      this.snakebar.open("title can't be empty","ok",{duration:3000});
      return;
   }
   if(this.category.description==null||this.category.description.trim()==''){
     this.snakebar.open("description can't be empty","ok",{duration:3000});
     return;
  }
    this.categoryService.addCategory(this.category).subscribe(
      (data)=>{
        console.log("category data from backend-end is "+data);
        this.snakebar.open("success!!","category is successfully added",{duration:3000});
         this.router.navigate(['admin/categories'])
      })
}
}
