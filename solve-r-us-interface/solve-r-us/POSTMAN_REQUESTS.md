## Get request
curl --header "Content-Type: application/json"  --request GET http://localhost:8080/customers/1

## Post request
curl --header "Content-Type: application/json"  \
--request POST  --data '{"firstName": "Michael","lastName": "Sample","company": "ACME"}' \
 http://localhost:8080/customers/ 