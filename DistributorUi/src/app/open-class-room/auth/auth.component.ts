import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  authStatus:boolean;

  constructor(
    private authService:AuthService,
    private router: Router) { }

  ngOnInit() {
    this.authStatus = this.authService.isAuth;
  }

  onSignIn(){
    this.authService.signIn().then(
      ()=>{
        alert('Sign in successfull');
        this.authStatus = this.authService.getAuth();
        this.router.navigate(['/open-class-room/open-class-room-appareils']);
      }
    )
  }
}
