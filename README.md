# Mock server - Spring-boot MongoDB

## Requests

- GET /mocks : return all mock-servers in the db.
- GET /mocks/{id} : returns mock-server associated with the provided id.
- POST /mocks : Add new mock-server to the db.
- PUT /mocks : Add new request to mock-server.
- DELETE /mocks/{id} : Remove mocks with the provided id.
- DELETE /mocks/{id}/{requestID} : Remove requests from mock-server with the provided id.
- Any request to /api route 
