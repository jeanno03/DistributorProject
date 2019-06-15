import { Injectable } from '@angular/core';
import { Credential } from '../model/credential.model';
import { Observable, BehaviorSubject, Subscription, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JwtServiceService {

  private token:string=this.getToken();

  tokenSubject= new Subject<string>();
  
  constructor(
    private http:HttpClient
    ) { }

  toConnectJwtPost(credential:Credential): Observable<Credential> {
    return this.http.post<any>('http://localhost:8080/DistributorBack_war/api/auth/testConnection', credential)
  }

  toConnect(token:string){
    localStorage.setItem('token', token);
    this.emitTokenSubject();
  }

  toDisconnect(){
    localStorage.removeItem('token');
  }

  emitTokenSubject(){
    this.token=this.getToken();

    if(localStorage.getItem('token')){
      this.tokenSubject.next(this.token.slice());
    }else{
      this.tokenSubject.next(null);
    }    
  }

  getToken(){
      return localStorage.getItem('token');
  }

}