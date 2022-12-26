import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user.model';
import { AuthService } from '../services/auth.service';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-mon-profil',
  templateUrl: './mon-profil.component.html',
  styleUrls: ['./mon-profil.component.css']
})
export class MonProfilComponent {
  currentUser = new User();


  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private userService: userService, private authservice : AuthService) {
    }

  ngOnInit(): void {
    this.userService.getUserByUsername(this.authservice.loggedUser).subscribe(user => this.currentUser = user); 
    console.log(this.currentUser); 

  }

  updateUser(){
    
    this.userService.updateUser(this.currentUser).
    subscribe(usr => {this.router.navigate(['mon_profil']);
  });
  }
  
}
