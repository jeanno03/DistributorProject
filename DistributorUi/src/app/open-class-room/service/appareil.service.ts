import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppareilService {

  constructor() { }

  appareilsSubject = new Subject<any[]>();

  private appareils = [
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

  emitAppareilSubject(){
    this.appareilsSubject.next(this.appareils.slice());
  }

  getAppareils(){
/*     this.emitAppareilSubject(); */
    return this.appareils;
  }

  swithAll(){
    for(let a of this.appareils){
      a.status='allumé';
    }
    this.emitAppareilSubject();
    return this.appareils;
  }

  swithOffAll(){
    for(let a of this.appareils){
      a.status='éteint'
      this.emitAppareilSubject();
    }
    return this.appareils;
  }

  switchOne(appareilName:string){
    this.appareils.forEach(a => 
      {
      if(a.name===appareilName){
        a.status='allumé';
        this.emitAppareilSubject();
      }
    });
    return this.appareils;
  }

  switchOffOne(appareilName:string){
    this.appareils.forEach(a=>{
      if(a.name===appareilName){
        a.status='éteint';
        this.emitAppareilSubject();
      }
      return this.appareils;
    })
  }

  getAppareilByName(name:string){
    const appareil = this.appareils.find(
      (a) => {
        return a.name === name;
        this.emitAppareilSubject();
      }
    );
    return appareil;
  }

  setAppareilName(name:string, paramName:string){
    this.appareils.forEach(a=>{
      if(a.name===name){
        a.name = paramName;
        this.emitAppareilSubject();
      }
    })
  }

}

