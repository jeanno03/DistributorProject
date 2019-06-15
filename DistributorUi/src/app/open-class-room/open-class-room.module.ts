import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OpenClassRoomComponent } from './open-class-room/open-class-room.component';
import { AppareilComponent } from './appareil/appareil.component';
import { OpenClassRoomRoutingModule } from './open-class-room-routing.module';
import { OpenClassRoomAppComponent } from './open-class-room-app/open-class-room-app.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BlogAppComponent } from './blog-app/blog-app.component';
import { BlogPostComponent } from './blog-post/blog-post.component';
import { AppareilService } from './service/appareil.service';
import { AuthComponent } from './auth/auth.component';
import { AppareilViewComponent } from './appareil-view/appareil-view.component';
import { AuthService } from './service/auth.service';
import { AppareilViewSimpleComponent } from './appareil-view-simple/appareil-view-simple.component';
import { EditAppareilComponent } from './edit-appareil/edit-appareil.component';
import { UserService } from './service/user.service';
import { UserListComponent } from './user-list/user-list.component';
import { NewUserComponent } from './new-user/new-user.component';


@NgModule({
  declarations: [
    OpenClassRoomComponent, 
    AppareilComponent, 
    OpenClassRoomAppComponent, 
    BlogAppComponent, 
    BlogPostComponent, 
    AuthComponent, 
    AppareilViewComponent, 
    AppareilViewSimpleComponent, 
    EditAppareilComponent,
    UserListComponent,
    NewUserComponent
  ],
  imports: [
    CommonModule,
    OpenClassRoomRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers:[
    AppareilService,
    AuthService,
    UserService
  ]
})
export class OpenClassRoomModule { }
