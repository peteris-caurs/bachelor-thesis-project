# Latvian Scrabble Web Application
Query the largest open Latvian lexical database, 
find out the most valuable words in Latvian Scrabble, 
create lists of your favorites and share with your friends! <br>

## How it works
<a href="http://www.youtube.com/watch?feature=player_embedded&v=lbRuM3H_qoU" target="_blank">
<img src="http://img.youtube.com/vi/lbRuM3H_qoU/0.jpg" alt="Fullstack GraphQL Web Application | Bachelor Thesis Project" width="240" height="180" border="10" />
</a>

### Fun Facts
The **top five 3-letter words** are [HOĶ](http://www.tezaurs.lv/#/sv/hoķ "http://www.tezaurs.lv/#/sv/hoķ") (23), [FUČ](http://www.tezaurs.lv/#/sv/fuč "http://www.tezaurs.lv/#/sv/fuč") (21), [KIČ](http://www.tezaurs.lv/#/sv/kič "http://www.tezaurs.lv/#/sv/kič") (21), [GHĪ](http://www.tezaurs.lv/#/sv/ghī "http://www.tezaurs.lv/#/sv/ghī") (19) and [ĶIŽ](http://www.tezaurs.lv/#/sv/ķiž "http://www.tezaurs.lv/#/sv/kiž") (19). <br>

The **most valuable word** in Latvian Scrabble is [**HLOROGĻŪDEŅRAŽI**](http://www.tezaurs.lv/#/sv/hlorogļūdeņraži "http://www.tezaurs.lv/#/sv/hlorogļūdeņraži") (59)!

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
`$ git clone https://github.com/peteris-caurs/latvian-scrabble-app.git && cd latvian-scrabble-app/`
2. Start MongoDB service <br>
`$ service mongod start`
3. Import database <br>
`$ cd ./latvianScrabbleDb/ && mongorestore --db latvianScrabbleDb --drop ./`
4. Start GraphQL server <br>
`$ cd ./graphql-server/ && mvn spring-boot:run`
5. Install dependencies and start client application <br>
`$ cd ./apollo-client/ && npm install && ng serve`

## Endpoints
### Server side
* Server - http://localhost:8080/graphql <br>
* GraphiQL (test queries) - http://localhost:8080/graphiql <br>

### Client side
* Client - http://localhost:4200/ <br>

## Acknowledgements
Largest open Latvian lexical database [Tēzaurs](http://www.tezaurs.lv/ "http://www.tezaurs.lv/")<br>
https://github.com/LUMII-AILab/Tezaurs

## License
This software is available under the [MIT](./LICENSE) license
