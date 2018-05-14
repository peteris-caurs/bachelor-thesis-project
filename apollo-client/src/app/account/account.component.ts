import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User, SignInPayload } from '../graphql/types';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { REMOVE_FROM_FAVORITES_MUTATION, RemoveWordFromFavoritesMutationResponse } from '../graphql/queries-mutations';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  signInPayload: SignInPayload;
  user: User;

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService, private apollo: Apollo) { }

  ngOnInit() {
    this.signInPayload = JSON.parse(this.userService.retrieve());
    this.user = this.signInPayload.user;
    console.log(this.user.favorites);
  }

  removeFromFavorites(i, word) {
    console.log(this.signInPayload.token);
    console.log(word.id);

    const addWordToFavoritesSubscription = this.apollo.mutate<RemoveWordFromFavoritesMutationResponse>({
      mutation: REMOVE_FROM_FAVORITES_MUTATION,
      variables: {
        userId: this.signInPayload.token,
        wordId: word.id,
      },
    })
      .subscribe((response) => {
        console.log(response.data);
        this.userService.removeWord(i);
      });

    this.subscriptions = [...this.subscriptions, addWordToFavoritesSubscription];
  }
}
