import { Component ,OnInit} from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
// import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  User:User={username:'',firstname:'',lastname:'',email:'',phonenumber:'',password:''};

  constructor(private UserService:UserService,private snakebar:MatSnackBar,private router:Router) { }


  ngOnInit(): void {
    
  }

  FormSubmit(){
    if(this.User.username==''||this.User.username==null){
      this.snakebar.open("username is required!!",'ok',{duration:3000});
      return;
    }
    if(this.User.email==null||this.User.firstname==null||this.User.lastname==null||this.User.phonenumber==null){
      this.snakebar.open("user email is required!!",'ok',{duration:3000});
      return;
    }
    //console.log(this.User);
    this.UserService.registerUser(this.User).subscribe((data)=>{console.log(data),this.snakebar.open("user is successfully registered",'ok',{duration:3000}),this.router.navigate(['login']);},(error)=>this.snakebar.open("something went wrong!! please try again...",'ok',{duration:3000}));
    //window.location.href='/login';
    
  }

}
