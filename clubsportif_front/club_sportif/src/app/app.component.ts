import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './model/user.model';
import { AuthService } from './services/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'club_sportif';

  loggedUser! : User; 

  constructor(public authService: AuthService,
    private router :Router){}

  ngOnInit() {
  
  console.log("Init App component! ")

  this.authService.loadToken();
  if (this.authService.getToken()==null){
    this.router.navigate(['/login']);
  }
  

}

  onLogout(){
  this.authService.logout();
}


}
