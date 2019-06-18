import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DistributorServiceService {

  constructor(private httpClient:HttpClient) { }

  generateDataTest(){
    return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/distributor/generateAppDistributorTest');
  }

  getAllDistributorDto(){
    return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/distributor/getAllDistributorsDto');
  }

  getCoins(){
    return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/enum/getCoins');
  }

  getDrinks(){
    return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/distributor/getDrinkDtos');
  }

  getDistributorDtoIfCoinIfDrink(
    coin:string,
    nbCoin:string,
    drink:string,
    nbDrink:string
  ){
return this.httpClient.get('http://localhost:8080/DistributorBack_war/api/distributor/getDistributorDtoIfCoinIfDrink/'+coin+'/'+nbCoin+'/'+drink+'/'+nbDrink+'');
  }
  
  saveDistributor(){
    //toDo
  }
  

}
