import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from '../model/role.model';
import { User } from '../model/user.model';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  currentUser = new User();
  roles! : Role[]; 
  currentUserRoles! : Role[];
  updatedRoleId! : number;   

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private userService: userService){
    }


  ngOnInit(): void {
    this.userService.consulterUser(this.activatedRoute.snapshot.params['id']).
    subscribe(usr => {this.currentUser = usr;
                      this.currentUserRoles = usr.roles;
    });

    this.userService.listeRoles().subscribe(rols => this.roles = rols._embedded.roles);
  }

  updateUser(){
    
    this.currentUserRoles.push(this.roles.find(rol => rol.role_id == this.updatedRoleId)!);
    this.userService.updateUser(this.currentUser).
    subscribe(usr => {this.router.navigate(['users']);
  });
  }

}
