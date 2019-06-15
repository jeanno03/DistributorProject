import { Injectable } from '@angular/core';
import { User } from '../model/user.model';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private users: User[] = [
    new User('Will', 'Alexander', 'will@will.com', 'jus d\'orange', ['coder', 'boire du café']),
    new User('William', 'Alexandra', 'willya@will.com', 'coca cola', ['dormir', 'boire du thé']),
  ];

  userSubject = new Subject<User[]>();

  constructor() { }

  emitUsers() {
    try{
    this.userSubject.next(this.users.slice());
    }catch(err){
      console.log(err);
    }
  }

  addUser(user: User) {
    this.users.push(user);
    this.emitUsers();
  }
}


