import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public loggedUser!: string;
  public isloggedIn: Boolean = false;
  public roles!: string[];
  apiURL: string = 'http://localhost:8081/users';
  token!:string;


  constructor(private router: Router,
              private http:HttpClient) {}

  login(user: User) {
    return this.http.post<User>(this.apiURL + '/login', user, {
      observe: 'response',
    });
  }

  saveToken(jwt: string) {
    localStorage.setItem('jwt', jwt);
    this.token = jwt;
    this.isloggedIn = true;
  }

  /*SignIn(user: User): Boolean {
    let validUser: Boolean = false;

    this.users.forEach((curUser) => {
      if (
        user.username == curUser.username &&
        user.password == curUser.password
      ) {
        validUser = true;
        this.loggedUser = curUser.username;
        this.isloggedIn = true;
        this.roles = curUser.roles;
        localStorage.setItem('loggedUser', this.loggedUser);
        localStorage.setItem('isloggedIn', String(this.isloggedIn));
      }
    });
    return validUser;
  }*/

  isAdmin(): Boolean {
    if (!this.roles)
      //this.roles== undefiened
      return false;
    return this.roles.indexOf('ADMIN') > -1;
  }
}
