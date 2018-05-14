# Latvian Scrabble application
Query the largest open Latvian lexical database, 
find out the most valuable words in Latvian Scrabble, 
create lists of your favorites and share with your friends!  😎 <br>

*Demo GIF of functionality coming soon...*

### Fun Facts
Here's a table of **top five 3-letter words**: <br>

| Word          | Score |
|:-------------:|:-----:|
|      hoķ      |  23   |
|      fuķ      |  21   |
|      ķič      |  21   |
|      ghī      |  19   |
|      ķiz      |  19   |

The most valuable word in Latvian Scrabble is **HLOROGĻŪDEŅRAŽI** with a score of **59**! 💪

## Setup
### Prerequesites
* Git
* JDK 1.8 or higher
* MongoDB
* Maven
* NPM
* Angular CLI

### Installation
1. Clone repository <br>
`git clone https://github.com/peteris-caurs/latvian-scrabble-app.git && cd latvian-scrabble-app/`
2. Start MongoDB service <br>
`service mongod start`
3. Import database <br>
`cd ./latvianScrabbleDb/ && mongorestore --db latvianScrabbleDb --drop ./`
4. Start GraphQL server <br>
`cd ./graphql-server/ && mvn spring-boot:run`
5. Install dependencies and start client application <br>
`cd ./apollo-client/ && npm install && ng serve`

## Endpoints
### Server side
* Server - http://localhost:8080/graphql <br>
* GraphiQL (test queries) - http://localhost:8080/graphiql <br>

### Client side
* Client - http://localhost:4200/ <br>

## Acknowledgements
* Largest open Latvian lexical database 
[Tēzaurs](http://www.tezaurs.lv/ "http://www.tezaurs.lv/")<br>
https://github.com/LUMII-AILab/Tezaurs
* Introduction to graphql-java
[HowToGraphQL](https://www.howtographql.com/graphql-java/0-introduction/ "https://www.howtographql.com/graphql-java/0-introduction/")<br>
https://github.com/kaqqao/graphql-java-1
* Building a GraphQL Server with Spring Boot
[Pluralsight](https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot/ "https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot/")<br>
https://github.com/eh3rrera/graphql-java-spring-boot-example
* Apollo Client For Angular
[Medium](https://medium.com/codingthesmartway-com-blog/apollo-client-for-angular-making-use-of-graphql-8d9a571e020c "https://medium.com/codingthesmartway-com-blog/apollo-client-for-angular-making-use-of-graphql-8d9a571e020c")<br>
https://github.com/seeschweiler/apollo-client-angular

## License
This software is available under the [MIT](./LICENSE) license
