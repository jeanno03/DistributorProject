import { Injectable } from '@angular/core';
import { Credential } from '../model/credential.model';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class JwtServiceService {

  constructor(
    private http:HttpClient
    ) { }

  toConnectJwtPost(credential:Credential): Observable<Credential> {
    return this.http.post<any>('http://localhost:8080/DistributorBack_war/api/auth/testConnection', credential)
  }

  toDisconnect(){
    localStorage.removeItem('token');
  }


}
