import { Component, OnInit, Input } from '@angular/core';
import { AppareilService } from '../service/appareil.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appareil',
  templateUrl: './appareil.component.html',
  styleUrls: ['./appareil.component.css']
})
export class AppareilComponent implements OnInit {

  @Input() appareilName: string;
  @Input() appareilStatus: string;
  @Input() index : number;

  @Input() name : string;

  constructor(
    private appareilService:AppareilService,
    private router:Router
    ) { }

  ngOnInit() {
  }

  getStatus(){
    return this.appareilStatus;
  }

  getColor() {
    if(this.appareilStatus === 'allumé') {
      return 'green';
    } else if(this.appareilStatus === 'éteint') {
      return 'red';
    }
}

switchOne(appareilName:string){
  if(this.appareilStatus==="éteint"){
    this.appareilService.switchOne(appareilName);
  } 
}

switchOffOne(appareilName:string){
  if(this.appareilStatus==="allumé"){
    this.appareilService.switchOffOne(appareilName);
  }
}

}
