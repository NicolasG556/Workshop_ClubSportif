import { Component } from '@angular/core';
import { Role } from '../model/role.model';
import { User } from '../model/user.model';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  users?: User[];
  roles?: Role[];

  constructor(private userService: userService) {}
  ngOnInit(): void {
    this.chargerUser();
    this.userService.listeRoles().
    subscribe(rols => {this.roles = rols._embedded.roles;
    });
    
  }

  chargerUser() {
    this.userService.listeUser().subscribe((users) => {
      console.log(users);

      this.users = users;
    });
  }


}
