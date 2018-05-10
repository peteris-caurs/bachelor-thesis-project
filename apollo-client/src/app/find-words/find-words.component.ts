import { Component, OnInit, OnDestroy } from '@angular/core';
import { Word } from '../graphql/types';
import { PosTag } from '../graphql/types';
import { Subscription } from 'rxjs/Subscription';
import { Apollo } from 'apollo-angular';
import { FIND_WORDS_QUERY, FindWordsQueryResponse } from '../graphql/queries-mutations';


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

  private subscriptions: Subscription[] = [];

  constructor(private apollo: Apollo) { }
  ngOnInit() {
    this.posTags = Object.values(PosTag);
  }

  findWords() {
    console.log(this.startsWith);
    console.log(this.endsWith);
    console.log(this.limit);
    console.log(this.selectedPosTag);
    console.log(this.maxLength);

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
        this.words = response.data.words;
        this.loading = response.data.loading;
      });

    this.subscriptions = [...this.subscriptions, findWordsQuerySubscription];
  }

  ngOnDestroy() {
    for (const sub of this.subscriptions) {
      if (sub && sub.unsubscribe) {
        sub.unsubscribe();
      }
    }
  }
}
