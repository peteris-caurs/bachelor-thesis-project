import { Component, OnInit, OnDestroy } from '@angular/core';
import { Word } from '../graphql/types';
import { PosTag } from '../graphql/types';
import { SignInPayload } from '../graphql/types';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { FIND_WORDS_QUERY, FindWordsQueryResponse } from '../graphql/queries-mutations';
import { ADD_TO_FAVORITES_MUTATION, AddWordToFavoritesMutationResponse } from '../graphql/queries-mutations';
import { UserService } from '../user.service';

@Component({
  selector: 'app-find-words',
  templateUrl: './find-words.component.html',
  styleUrls: ['./find-words.component.scss']
})
export class FindWordsComponent implements OnInit, OnDestroy {

  words: Word[];
  loading = true;

  startsWith: string;
  endsWith: string;
  limit: number;
  posTags: string[];
  selectedPosTag: PosTag;
  maxLength: number;

  signInPayload: SignInPayload;

  private subscriptions: Subscription[] = [];

  constructor(private apollo: Apollo, private userService: UserService) { }
  ngOnInit() {
    this.posTags = Object.values(PosTag);
    this.signInPayload = JSON.parse(this.userService.retrieve());
  }

  findWords() {
    const findWordsQuerySubscription = this.apollo.watchQuery<FindWordsQueryResponse>({
      query: FIND_WORDS_QUERY,
      variables: {
        startsWith: this.startsWith,
        endsWith: this.endsWith,
        limit: this.limit,
        posTag: this.selectedPosTag,
        maxLength: this.maxLength
      },
    })
      .valueChanges
      .subscribe((response) => {
        this.loading = response.data.loading;
        this.words = response.data.findWordsBy;
      });

    this.subscriptions = [...this.subscriptions, findWordsQuerySubscription];
  }

  addToFavorites(word: Word) {
    console.log(this.signInPayload.token);
    console.log(word.id);

    const addWordToFavoritesSubscription = this.apollo.mutate<AddWordToFavoritesMutationResponse>({
      mutation: ADD_TO_FAVORITES_MUTATION,
      variables: {
        userId: this.signInPayload.token,
        wordId: word.id,
      },
    })
      .subscribe((response) => {
        console.log(response.data);
        this.userService.addWord(word);
      });

    this.subscriptions = [...this.subscriptions, addWordToFavoritesSubscription];
  }

  ngOnDestroy() {
    for (const sub of this.subscriptions) {
      if (sub && sub.unsubscribe) {
        sub.unsubscribe();
      }
    }
  }
}
