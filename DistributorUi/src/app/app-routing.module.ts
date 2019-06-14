import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ManagerComponent } from './manager/manager.component';
import { AuthGuardService } from 'src/service/auth-guard.service';
import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';


const routes: Routes = [
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'manager',
    component:ManagerComponent,
    canActivate: [AuthGuardService] 
  },
  { path: '', component: HomeComponent },
  {
    path:'not-found',
    component:FourOhFourComponent
  },
/*   { 
    path: '**', 
    redirectTo: 'not-found' 
  } */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
