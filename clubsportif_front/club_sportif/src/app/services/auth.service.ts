import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user.model';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private helper = new JwtHelperService();
  public loggedUser!: string;
  public loggedUserid! : number;
  public isloggedIn: Boolean = false;
  public roles!: string[];
  apiURL: string = 'http://localhost:8081/users';
  token!: string;

  constructor(private router: Router, private http: HttpClient) {}

  login(user: User) {
    return this.http.post<User>(this.apiURL + '/login', user, {
      observe: 'response',
    });
  }

  logout() {
    this.loggedUser = undefined!;
    this.roles = undefined!;
    this.token = undefined!;
    this.isloggedIn = false;
    localStorage.removeItem('jwt');
    this.router.navigate(['/login']);
  }

  saveToken(jwt: string) {
    localStorage.setItem('jwt', jwt);
    this.token = jwt;
    this.isloggedIn = true;
    this.decodeJWT();
  }

  decodeJWT() {
    if (this.token == undefined) return;

    const decodedToken = this.helper.decodeToken(this.token);
    this.roles = decodedToken.roles;
    this.loggedUser = decodedToken.sub;
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
    return this.roles.indexOf('ADMIN') >= 0;
  }

  isCoach(): Boolean {
    if (!this.roles)
      //this.roles== undefiened
      return false;
    return this.roles.indexOf('COACH') >= 0;
  }

  getToken(): string {
    return this.token;
  }

  loadToken() {
    this.token = localStorage.getItem('jwt')!;
    this.decodeJWT();
  }

}
