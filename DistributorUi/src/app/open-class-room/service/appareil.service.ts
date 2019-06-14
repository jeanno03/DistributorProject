import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppareilService {

  constructor() { }

  appareils = [
    {
      name: 'Machine à laver',
      status: 'éteint'
    },
    {
      name: 'Frigo',
      status: 'allumé'
    },
    {
      name: 'Ordinateur',
      status: 'éteint'
    }
  ];

  getAppareils(){
    return this.appareils;
  }

  swithAll(){
    for(let a of this.appareils){
      a.status='allumé';
    }
    return this.appareils;
  }

  swithOffAll(){
    for(let a of this.appareils){
      a.status='éteint'
    }
    return this.appareils;
  }

  switchOne(appareilName:string){
    this.appareils.forEach(a => 
      {
      if(a.name===appareilName){
        a.status='allumé';
      }
    });
    return this.appareils;
  }

  switchOffOne(appareilName:string){
    this.appareils.forEach(a=>{
      if(a.name===appareilName){
        a.status='éteint';
      }
      return this.appareils;
    })
  }

  getAppareilByName(name:string){
    const appareil = this.appareils.find(
      (a) => {
        return a.name === name;
      }
    );
    return appareil;
  }

  setAppareilName(name:string, paramName:string){
    this.appareils.forEach(a=>{
      if(a.name===name){
        a.name = paramName;
      }
    })
  }

}

