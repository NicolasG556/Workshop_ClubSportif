import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from '../model/role.model';
import { User } from '../model/user.model';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  apiURL: string = 'http://localhost:8081/users/register';

  constructor(private http:HttpClient, private userService:userService,
              private router : Router){
    
  }
  newUser = new User();
  user = new User();
  roles! : Role[]; 
  newIdRole! : number; 
  newRole! : Role; 


  register() {
    this.newUser.roles.push(this.roles.find(rol => rol.idRole = this.newIdRole)!);
    this.userService.ajouterUser(this.newUser).
    subscribe(user => {
      
      console.log(user);
      this.router.navigate(['/']);
    });
   
  }
}
