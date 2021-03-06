import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { MyUserModule } from './my-user/my-user.module';
import { HttpClientModule } from '@angular/common/http';
import { ManagerComponent } from './manager/manager.component';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OpenClassRoomModule } from './open-class-room/open-class-room.module';
import { JwtServiceService } from 'src/service/jwt-service.service';
import { DistributorServiceService } from 'src/service/distributor-service.service';
import { MyUserServiceService } from 'src/service/my-user-service.service';
import { AuthGuardService } from 'src/service/auth-guard.service';
import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { DistributorComponent } from './distributor/distributor.component';
import { FieldService } from 'src/service/field.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
// https://appdividend.com/2018/12/14/angular-7-routing-and-sub-routing-tutorial-with-example/
// shift + alt + a pour commenter le code (windows)
// ctrl + k + c/u pour commenter le code (linux)
// https://modev.net/angular-6-implement-auth-guard-to-your-project/
// ctrl + shift + i pour formater (linux)
// npm i ngx-bootstrap
//https://www.freakyjolly.com/angular-7-6-add-data-tables-with-ultimate-features-in-few-steps/#more-2308

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ManagerComponent,
    FourOhFourComponent,
    DistributorComponent,
  ],
  imports: [
    BsDropdownModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    MyUserModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    OpenClassRoomModule,
    NgxDatatableModule
  ],
  providers: [
    JwtServiceService, 
    DistributorServiceService, 
    MyUserServiceService,
    AuthGuardService,
    FieldService],
  bootstrap: [AppComponent]
})
export class AppModule { }
