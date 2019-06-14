import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyUserComponent } from './my-user/my-user.component';
import { MyUserLoginComponent } from './my-user-login/my-user-login.component';
import { MyUserMySpaceComponent } from './my-user-my-space/my-user-my-space.component';
import { MyUserRoutingModule } from './my-user-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthGuardService } from 'src/service/auth-guard.service';

@NgModule({
  declarations: [MyUserComponent, MyUserLoginComponent, MyUserMySpaceComponent],
  imports: [
    CommonModule,
    MyUserRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers:[
/*     AuthGuardService */
  ]
})
export class MyUserModule { }
