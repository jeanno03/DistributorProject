import { Component, OnInit, Injectable } from '@angular/core';
import { JwtServiceService } from '../../service/jwt-service.service';
import { 
  ActivatedRouteSnapshot, 
  CanActivate, 
  Router, 
  RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

@Injectable()
export class HeaderComponent implements OnInit {

  constructor(
    private jwtServiceService: JwtServiceService,
    private router: Router
    ) { }

    ngOnInit() {
    }

  logout(){
    this.jwtServiceService.toDisconnect();
    this.router.navigate( ["/myUser/login"] );
  }

}
