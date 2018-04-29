import gql from 'graphql-tag';

export const ALL_WORDS = gql`
  query findWordsByEmptyInput{
    findWordsBy(input:{}){
      headword
      posTag
      score
      length
    }
  }
`;
