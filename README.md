#POST Example

curl -X POST localhost:8080/buy-gas-service -H 'Content-type:application/json' -d '{"email": "aguilar@srpago.com", "name": "Raulo", "lastName": "Aguilar Benitez", "cardNumber": "9877654432114561", "expirationDateYear": "2010", "expirationDateMonth": "8", "gasType": "2", "amount": "200.00", "gasStation": "587fbd68edfe99480a072f81", "sellerName": "Cristina"}'
