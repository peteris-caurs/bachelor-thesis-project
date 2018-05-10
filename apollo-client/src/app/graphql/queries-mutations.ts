import { PosTag } from './types';
import { Word } from './types';
import { User } from './types';

import gql from 'graphql-tag';

export const FIND_WORDS_QUERY = gql`
query findWords(
    $startsWith: String,
    $endsWith: String,
    $limit: Int,
    $posTag: PosTag,
    $maxLength: Int){
    findWordsBy(input: {
      startsWith: $startsWith,
      endsWith: $endsWith,
      limit: $limit,
      posTag: $posTag,
      maxLength: $maxLength
    }){
      id
      headword
      posTag
      sources
      score
      length
    }
  }
`;

export interface FindWordsQueryResponse {
  words: Word[];
  loading: boolean;
}

export const SIGNUP_USER_MUTATION = gql`
mutation signUp(
    $name: String,
    $email: String,
    $password: String
){
  signUpUser(input:{
    name: $name,
    email: $email,
    password: $password
  }){
    name
    createdAt
  }
}
`;

export interface SignUpUserMutationResponse {
  user: User;
  loading: boolean;
}
