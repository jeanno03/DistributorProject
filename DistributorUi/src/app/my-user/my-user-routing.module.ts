import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MyUserComponent } from './my-user/my-user.component';
import { MyUserLoginComponent } from './my-user-login/my-user-login.component';
import { MyUserMySpaceComponent } from './my-user-my-space/my-user-my-space.component';
import { AuthGuardService } from 'src/service/auth-guard.service';

const routes: Routes = [
    {
        path: 'myUser',
        component: MyUserComponent,
        children: [
            {
                path: 'login',
                component: MyUserLoginComponent
            },
            {
                path: 'mySpace',
                component: MyUserMySpaceComponent,
                canActivate: [AuthGuardService] 
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class MyUserRoutingModule { }