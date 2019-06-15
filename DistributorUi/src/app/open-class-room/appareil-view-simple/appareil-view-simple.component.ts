import { Component, OnInit } from '@angular/core';
import { AppareilService } from '../service/appareil.service';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject, interval, Subscription  } from 'rxjs';

@Component({
  selector: 'app-appareil-view-simple',
  templateUrl: './appareil-view-simple.component.html',
  styleUrls: ['./appareil-view-simple.component.css']
})
export class AppareilViewSimpleComponent implements OnInit {

  appareil:any=[];
  name:any;
  paramName : any;

  secondes:number;
  counterObservable:Subscription;

  constructor(
    private appareilService:AppareilService,
    private route:ActivatedRoute) { }

  ngOnInit() {
    var tempName =this.route.snapshot.params['name'];
    this.name = tempName;
    var tempName =this.route.snapshot.params['paramName'];
    this.paramName = tempName;
    this.appareilService.setAppareilName(this.name, this.paramName);
    this.appareil.name = this.appareilService.getAppareilByName(this.paramName).name;
    this.appareil.status = this.appareilService.getAppareilByName(this.paramName).status;

    this.getCounterObservable();

  }

  getCounterObservable(){
    const counter = interval(1000);
    this.counterObservable = counter.subscribe( 
      (data) => {
        this.secondes=data;   
      },      
      (error) => {
        console.log("error : " + error);
      },
      ()=>{
        console.log("observable complete!");
      }
    );
  }

  // empêche les comportements inattendus liés aux Observables infinis, 
  ngOnDestroy(){
    this.counterObservable.unsubscribe();
  }

}
