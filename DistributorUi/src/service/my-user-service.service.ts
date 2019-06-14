import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyUserServiceService {

  constructor(private http : HttpClient) { }


  generateMyUsers(){
    return this.http.get('http://localhost:8080/DistributorBack_war/api/user/generateMyUsers');
  }

  getAllMyUsers(){
    return this.http.get('http://localhost:8080/DistributorBack_war/api/user/getAllMyUserDtos');
  }

}
