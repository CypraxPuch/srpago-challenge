#Instalation process

1. Download the project

    `git clone https://github.com/CypraxPuch/srpago-challenge.git`

2. Build the project
    
    `mvn clean install`

3. A `war file` should be generated inside the project directory `tarjet/`
    
    #####Example
    
    if your `home directory` is: `/<any-directory>/srpago/`
    
    then the `war file` will be located in: `/<any-directory>/srpago/target/`
    
    The `war file name` is: `srpago-0.0.1-SNAPSHOT.war`   
####Important: You can deploy the `war file` in any Application Server but in this case we're gonna build and run in just a few steps.

###Database 

1. The DB are going to be created with an initial script within a docker container and the schema will be named: `srpagodb`
2. Copy the script, that you can find inside the project in directory:
    
    `/<any-directory>/srpago/src/main/resources/dbscripts/V1__create_initial_schema.sql`
    
    and paste it in any local directory, for example:
    
    `/opt/ledze/srpago-challenge-scripts/`  

###Build & Run
Open up 1 command line terminal:
1. Execute command `docker build -f Dockerfile -t srpago-webapp .`
2. Execute command `docker-compose -f docker-compose.yml up` 


#Test the endpoint

1. Once the `war file` was deployed then a RESTfull endpoint will be exposed:

    `http://localhost:8080/srpago-0.0.1-SNAPSHOT/buy-gas-service`

####To test the endpoint should be a POST Example

`curl -X POST localhost:8080/srpago-0.0.1-SNAPSHOT/buy-gas-service -H 'Content-type:application/json' -d '{"email": "pucheta@srpago.com", "name": "Gerardo", "lastName": "Pucheta Figueroa", "cardNumber": "9877654432114561", "expirationDateYear": "2010", "expirationDateMonth": "8", "gasType": "2", "amount": "200.00", "gasStation": "587fbd68edfe99480a072f81", "sellerName": "Cristina"}'`

####Success execution

`{"success":true,"error":null,"message":"Correct Information"}`

####Example of an errored execution

`{"success":false,"error":"400 BAD_REQUEST","message":"Expiration date month must be equals or greater than 10,Expiration date year must be equals or greater than 2019"}`



