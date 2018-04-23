import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

// apollo
import { HttpClientModule } from '@angular/common/http';
import { ApolloModule ,Apollo } from 'apollo-angular';
import { HttpLinkModule, HttpLink } from 'apollo-angular-link-http';
import { InMemoryCache } from 'apollo-cache-inmemory';

import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule, // provides HttpClient for HttpLink
    ApolloModule,
    HttpLinkModule
  ],
  schemas: [NO_ERRORS_SCHEMA], 
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(
    apollo: Apollo,
    httpLink: HttpLink
  ) {
    apollo.create({
      // By default, this client will send queries to the
      // `/graphql` endpoint on the same host
      link: httpLink.create({ uri: "https://api.example.com/graphql" }),
      cache: new InMemoryCache()
    });
  }
}
