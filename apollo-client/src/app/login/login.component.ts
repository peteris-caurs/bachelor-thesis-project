import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { SIGNIN_USER_MUTATION, SignInUserMutationResponse } from '../graphql/queries-mutations';
import { SignInPayload } from '../graphql/types';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  email: string;
  password: string;

  token: string;

  private subscriptions: Subscription[] = [];

  constructor(private apollo: Apollo) { }

  ngOnInit() { }

  signIn() {
    this.email = this.email;
    this.password = this.password;

    const SignUpUserMutationSubscription = this.apollo.mutate<SignInUserMutationResponse>({
      mutation: SIGNIN_USER_MUTATION,
      variables: {
        email: this.email,
        password: this.password
      },
    })
      .subscribe((response) => {
        // this.token = response.data.SignInPayload.token;
        console.log(response.data);
      });

    this.subscriptions = [...this.subscriptions, SignUpUserMutationSubscription];
  }

  ngOnDestroy() {
    for (const sub of this.subscriptions) {
      if (sub && sub.unsubscribe) {
        sub.unsubscribe();
      }
    }
  }

}
