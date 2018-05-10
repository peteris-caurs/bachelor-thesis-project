import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from '../graphql/types';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { SIGNUP_USER_MUTATION, SignUpUserMutationResponse } from '../graphql/queries-mutations';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit, OnDestroy {

  name: string;
  email: string;
  password: string;

  user: User = new User();

  private subscriptions: Subscription[] = [];

  constructor(private apollo: Apollo) { }

  ngOnInit() {
  }

  signUp() {
    console.log(this.name);
    console.log(this.email);
    console.log(this.password);

    this.user.name = this.name;
    this.user.email = this.email;
    this.user.password = this.password;

    const SignUpUserMutationSubscription = this.apollo.mutate<SignUpUserMutationResponse>({
      mutation: SIGNUP_USER_MUTATION,
      variables: {
        name: this.name,
        email: this.email,
        password: this.password
      },
    })
      .subscribe((response) => {
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
