// Part of speech tag
export enum PosTag {
    Adjective = 'ADJ',
    Adposition = 'ADP',
    Adverb = 'ADV',
    CoordinatingConjunction= 'CONJ',
    Interjection= 'INTJ',
    Noun = 'NOUN',
    Numeral = 'NUM',
    Particle = 'PART',
    Pronoun = 'PRON',
    Verb = 'VERB',
    Other = 'X',
    Unasigned = 'NULL'
}

export class Word {
    id: string;
    headword: string;
    posTag: PosTag;
    sources: string;
    score: number;
    length: number;
}

export class User {
    id: string;
    name: string;
    email: string;
    password: string;
    createdAt: string;
    favorites: [Word];
}
