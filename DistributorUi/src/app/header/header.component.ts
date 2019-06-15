import { Component, OnInit, Injectable } from '@angular/core';
import { JwtServiceService } from '../../service/jwt-service.service';
import { 
  ActivatedRouteSnapshot, 
  CanActivate, 
  Router, 
  RouterStateSnapshot } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { map, take } from 'rxjs/operators';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

@Injectable()
export class HeaderComponent implements OnInit {

  tokenSubscription:Subscription;
  token:string;

  constructor(
    private jwtServiceService: JwtServiceService,
    private router: Router
    ) { }

    ngOnInit() {
      //display login or login at start
      this.token=localStorage.getItem('token');
      //display login or login when connect or disconnect
      this.tokenSubscription=this.jwtServiceService.tokenSubject.subscribe(
        (token:string)=>{
          this.token=token;
        }
      )
    }

  logout(){
    this.jwtServiceService.toDisconnect();
    this.jwtServiceService.emitTokenSubject();
    this.router.navigate( ["/myUser/login"] );
  }

  ngOnDestroy(){
    this.tokenSubscription.unsubscribe();
  }

}
