import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';
import { Role } from '../model/role.model';
import { AuthService } from './auth.service';
import { RoleWrapper } from '../model/roleWrapped.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class userService {
  user!: User[];
  apiURLregister: string = 'http://localhost:8081/users/api/register';
  apiURL: string = 'http://localhost:8081/users/api';
  apiUrlRoles: string = 'http://localhost:8081/users/ressource_role';
  apiUrlUpdateUser: string = 'http://localhost:8081/users/api//addRoleToUser';

  constructor(private http: HttpClient, private authService:AuthService) {
 
  }

  listeUser(): Observable<User[]> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt})
    return this.http.get<User[]>(this.apiURL+"/all",{headers:httpHeaders});
  }

  ajouterUser(usr: User): Observable<User> {
    return this.http.post<User>(this.apiURLregister, usr, httpOptions);
  }

  //A METTRE EN PLACE

 /* supprimerUser(id: number): Observable<User> {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete<User>(url, httpOptions);
  }

  consulterUser(id: number): Observable<User> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<User>(url);
  }*/

  updateUser(usr: User): Observable<User> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
    return this.http.put<User>(this.apiURL, usr, {headers:httpHeaders});
  }

  listeRoles():Observable<RoleWrapper> {
    return this.http.get<RoleWrapper>(this.apiUrlRoles);
  }

  consulterUser(id: number): Observable<User> {
    const url = `${this.apiURL}/${id}`;
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
      return this.http.get<User>(url,{headers:httpHeaders});
    }

    ajouterRoleAUser(usr: User): Observable<User> {
      let jwt = this.authService.getToken();
      jwt = "Bearer "+jwt;
      let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
      return this.http.post<User>(this.apiURL + "/addRoleToUser", usr, {headers:httpHeaders});
    }


}
