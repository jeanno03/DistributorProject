import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { JwtServiceService } from 'src/service/jwt-service.service';
import { Router } from '@angular/router';
import { Credential } from 'src/model/credential.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-my-user-login',
  templateUrl: './my-user-login.component.html',
  styleUrls: ['./my-user-login.component.css']
})
export class MyUserLoginComponent implements OnInit {
  
  login = new FormControl('');
  password = new FormControl('');
  form: FormGroup;   

  constructor(
    private jwtServiceService: JwtServiceService, 
    private router :Router,
    private fb: FormBuilder, ) { }

  ngOnInit() {
  }

  submitConnexion(){
    var credential= new Credential();
    credential.login = this.login.value ;
    credential.password = this.password.value ;

    this.jwtServiceService.toConnectJwtPost(credential)
    .subscribe((resp: any) => {
      // localStorage.setItem('token', resp.token);
      
      this.jwtServiceService.toConnect(resp.token);
      console.log("token : " + localStorage.getItem('token'));
      this.jwtServiceService.emitTokenSubject();
      this.router.navigate(['/home']);

    }, err => {
      console.log(err);
      alert(err.status);
    })
  }



}
