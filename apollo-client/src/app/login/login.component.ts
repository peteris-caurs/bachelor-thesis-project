import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { SIGNIN_USER_MUTATION, SignInUserMutationResponse } from '../graphql/queries-mutations';
import { SignInPayload } from '../graphql/types';
import { UserService } from '../user.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  email: string;
  password: string;

  private subscriptions: Subscription[] = [];

  constructor(private apollo: Apollo, private userService: UserService, private router: Router) { }

  ngOnInit() { }

  signIn() {
    this.email = this.email;
    this.password = this.password;

    const SignInUserMutationSubscription = this.apollo.mutate<SignInUserMutationResponse>({
      mutation: SIGNIN_USER_MUTATION,
      variables: {
        email: this.email,
        password: this.password
      },
    })
      .subscribe((response) => {
        this.userService.store(response.data.signInUser.token, response.data.signInUser.user);
        this.router.navigate(['about']);
      });

    this.subscriptions = [...this.subscriptions, SignInUserMutationSubscription];
  }

  ngOnDestroy() {
    for (const sub of this.subscriptions) {
      if (sub && sub.unsubscribe) {
        sub.unsubscribe();
      }
    }
  }

}
