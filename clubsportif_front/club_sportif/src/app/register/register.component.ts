import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from '../model/role.model';
import { User } from '../model/user.model';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  newUser = new User();
  user = new User();
  roles! : Role[]; 
  newIdRole! : number; 
  newRole! : Role; 
  
  apiURL: string = 'http://localhost:8081/users/api/register';

  constructor(private http:HttpClient, private userService:userService,private router : Router){
    
  }


  ngOnInit(): void {
    this.userService.listeRoles().subscribe(rols => this.roles = rols._embedded.roles);
  }


  register() {
    
    this.newUser.roles = [];
    this.newUser.roles.push(this.roles.find(rol => rol.role_id = 2)!);
    this.newUser.enabled = 1; 
    this.userService.ajouterUser(this.newUser).
    subscribe(user => {
      
      
      this.router.navigate(['/']);
    });

   
  }
}
