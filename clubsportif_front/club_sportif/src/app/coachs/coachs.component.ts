import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { userService } from '../services/user.service';

@Component({
  selector: 'app-coachs',
  templateUrl: './coachs.component.html',
  styleUrls: ['./coachs.component.css']
})
export class CoachsComponent implements OnInit {

  coachs! : User[]; 

  constructor(private userService : userService){

  }

  ngOnInit(): void {
    this.userService.getCoach().subscribe(c => {
      this.coachs = c; 
    });
  }

  

}
