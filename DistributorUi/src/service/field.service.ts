import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class FieldService {

  constructor(
    private httpClient:HttpClient) { }

  getDistributorField(){
    return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/field/getCoinJsonHashMapField');
  }
}
