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
####Important: You can deploy the `war file` in any Application Server

###Database 

1. Create a `db schema` named as: `srpagodb`
2. Run the script that you can find inside the project in directory:
    
    `/<any-directory>/srpago/src/main/resources/initial-script.sql`  
#####Note: If for any reason you've changed the `db schema name` then you should change the parameter in the configuration file:

    ######application.properties
    In this file  you can find all the DB configuration like: user, password and the url

    spring.datasource.url= jdbc:mysql://localhost:3306/srpagodb?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC 
    

#Test the endpoint

1. Once the `war file` was deployed then a RESTfull endpoint will be exposed:

    `/buy-gas-service`

####To test the endpoint should be a POST Example

`curl -X POST localhost:8080/buy-gas-service -H 'Content-type:application/json' -d '{"email": "pucheta@srpago.com", "name": "Gerardo", "lastName": "Pucheta Figueroa", "cardNumber": "9877654432114561", "expirationDateYear": "2010", "expirationDateMonth": "8", "gasType": "2", "amount": "200.00", "gasStation": "587fbd68edfe99480a072f81", "sellerName": "Cristina"}'`

####Success execution

`{"success":true,"error":null,"message":"Correct Information"}`

####Example of an errored execution

`{"success":false,"error":"400 BAD_REQUEST","message":"Expiration date month must be equals or greater than 10,Expiration date year must be equals or greater than 2019"}`



