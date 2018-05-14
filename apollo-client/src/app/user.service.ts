import { Injectable } from '@angular/core';
import { User, Word, SignInPayload } from './graphql/types';

@Injectable()
export class UserService {

  private token: string;
  private user: User;
  private signInPayload: SignInPayload;

  store(token: string, user: User) {
    localStorage.setItem('user', JSON.stringify({token, user}));
  }

  addWord(word: Word) {
    const storedUser: string = localStorage.getItem('user');
    this.signInPayload = JSON.parse(this.retrieve());
    console.log('adding word to local storage');
    this.signInPayload.user.favorites.push(word);
    const token = this.signInPayload.token;
    const user = this.signInPayload.user;
    localStorage.setItem('user', JSON.stringify({token, user}));
  }

  removeWord(index: number) {
    const storedUser: string = localStorage.getItem('user');
    this.signInPayload = JSON.parse(this.retrieve());
    console.log('adding word to local storage');
    this.signInPayload.user.favorites.splice(index, 1);
    const token = this.signInPayload.token;
    const user = this.signInPayload.user;
    localStorage.setItem('user', JSON.stringify({token, user}));
  }

  retrieve() {
    const storedUser: string = localStorage.getItem('user');
    if (!storedUser) {
      throw new Error('no user found');
    }
    return storedUser;
  }

  deleteAll() {
    localStorage.clear();
  }

  constructor() { }

}
