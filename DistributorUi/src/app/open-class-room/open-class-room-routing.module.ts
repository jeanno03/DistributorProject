import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OpenClassRoomComponent } from './open-class-room/open-class-room.component';
import { OpenClassRoomAppComponent } from './open-class-room-app/open-class-room-app.component';
import { BlogAppComponent } from './blog-app/blog-app.component';
import { AppareilViewComponent } from './appareil-view/appareil-view.component';
import { AuthComponent } from './auth/auth.component';
import { AppareilViewSimpleComponent } from './appareil-view-simple/appareil-view-simple.component';
import { AuthGuardService } from 'src/service/auth-guard.service';
import { EditAppareilComponent } from './edit-appareil/edit-appareil.component';
import { UserListComponent } from './user-list/user-list.component';


const routes: Routes = [
    {
        path: 'open-class-room',
        component: OpenClassRoomComponent,
        children: [
            {
                path: 'open-class-room-app',
                component: OpenClassRoomAppComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'open-class-room-appareils',
                component: AppareilViewComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'open-class-room-appareils/:name/:paramName',
                component: AppareilViewSimpleComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'open-class-room-edit',
                component: EditAppareilComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'open-class-room-users',
                component: UserListComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'open-class-room-auth',
                component: AuthComponent,
                canActivate: [AuthGuardService]
            },
            {
                path: 'blog-app',
                component: BlogAppComponent,
                canActivate: [AuthGuardService]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class OpenClassRoomRoutingModule { }