import { Component, OnInit, Input } from '@angular/core';
import { AppareilService } from '../service/appareil.service';
import { AuthService } from '../service/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-appareil-view',
  templateUrl: './appareil-view.component.html',
  styleUrls: ['./appareil-view.component.css']
})
export class AppareilViewComponent implements OnInit {

  isAuth = false;

  lastUpdate = new Promise((resolve,reject)=>{
    const date = new Date();
    setTimeout(
      ()=>{
        resolve(date);
      },2000
    );
  });

  appareils :any = [];
  appareilSubscription:Subscription;
  authStatus: boolean = true;
  
  constructor(
    private appareilService:AppareilService,
    private authService:AuthService) {
   }

  ngOnInit() {
    setTimeout(
      ()=>{
        this.isAuth=true;
      },1000
    );

  this.appareilSubscription=this.appareilService.appareilsSubject.subscribe(
    (appareils:any[])=>{
      this.appareils=appareils;
    }
  );
  this.appareilService.emitAppareilSubject();

/*     this.appareils = this.appareilService.getAppareils(); */
    this.authStatus = this.authService.getAuth();
  }

  onAllumer(){
    this.appareils = this.appareilService.swithAll();
  }

  onEteindre(){
    if(confirm('Are you sure?')){
      this.appareils = this.appareilService.swithOffAll();
    }
  }

  onSignOut(){
    this.authStatus = this.authService.signOut();
  }

  ngOnDestroy() {
    this.appareilSubscription.unsubscribe();
  }

}