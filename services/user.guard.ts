import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(private loginservice:LoginService,private router:Router,private snakebar:MatSnackBar){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.loginservice.IsloggedIn()&&this.loginservice.getUserAuthority()=='USER'){
        return true;
      }
      this.router.navigate(['login']);
      this.snakebar.open("please login first to reach out to user functionalities",'ok');
    return false;
  }
  
  
}
