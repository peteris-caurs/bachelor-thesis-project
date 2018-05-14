import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { SignInPayload } from '../graphql/types';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  signInPayload: SignInPayload;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.signInPayload = JSON.parse(this.userService.retrieve());
  }

  logOut() {
    console.log('logout');
    this.userService.deleteAll();
  }

}
