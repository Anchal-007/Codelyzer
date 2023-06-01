import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar  } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { MatCard  } from '@angular/material/card';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SideBarComponent implements OnInit {
  isLoggedIn:boolean=false;
  user:any=null;

  constructor(private loginservice:LoginService,private snakebar:MatSnackBar,private router:Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.loginservice.logout();
    //window.location.href='/login';
    this.router.navigate(['login']);
    this.snakebar.open("you have successfully logged out","ok");
  }

  

}
