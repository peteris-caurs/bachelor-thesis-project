import { Component } from '@angular/core';
import { Apollo } from 'apollo-angular';

import { ALL_WORDS } from './types';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  constructor(apollo: Apollo) {
    apollo.query({query: ALL_WORDS}).subscribe(console.log);
  }
}
