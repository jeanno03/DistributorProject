import { Component, OnInit } from '@angular/core';
import { AppareilService } from '../service/appareil.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-appareil-view-simple',
  templateUrl: './appareil-view-simple.component.html',
  styleUrls: ['./appareil-view-simple.component.css']
})
export class AppareilViewSimpleComponent implements OnInit {

  appareil:any=[];
  name:any;
  paramName : any;

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
  }

}
