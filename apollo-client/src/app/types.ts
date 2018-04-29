import gql from 'graphql-tag';

export const ALL_WORDS = gql`
{
    allWords {
      headword
    }
}  
`;