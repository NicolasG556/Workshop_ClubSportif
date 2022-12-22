import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class userService {
  user!: User[];
  apiURLregister: string = 'http://localhost:8081/users/register';
  apiURL: string = 'http://localhost:8081/users';
  constructor(private http: HttpClient) {
 
  }

  listeUser(): Observable<User[]> {
    return this.http.get<User[]>(this.apiURL);
  }

  ajouterUser(usr: User): Observable<User> {
    return this.http.post<User>(this.apiURLregister, usr, httpOptions);
  }

  supprimerUser(id: number): Observable<User> {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete<User>(url, httpOptions);
  }

  consulterUser(id: number): Observable<User> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<User>(url);
  }

  updateUser(usr: User): Observable<User> {
    return this.http.put<User>(this.apiURL, usr, httpOptions);
  }


}
