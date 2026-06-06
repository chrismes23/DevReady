# DevReady
Official repository for projects about DevReady accelerator

The Main class shows an example on calling the required methods from the services.

## Running
A Java 17+ installation is required to run the project
To run the demo open a terminal and execute the following commands:

for Windows:
``` bash
.\mnvw.cmd spring-boot:run
```
for other platforms (hasn't been tested)
``` bash
chmod +x mvnw
./mvnw spring-boot:run
```
### The following endpoints are supported:
```
GET /calls
```
Returns a JSON list with all calls
```
GET /calls/{call-id}
```
Returns the call with the specified id or 404 if not found
```
PATCH /calls/{call-id}/archive
```
Archives a call with the specified id so it doesn't appear in the list

## Tech stack
The project was build with Java and Spring boot framework using Maven for building.
org.json library is used to parse JSON objects from file to memory

## Testing

There have been written tests that test core functionality of the API with MockMvc
To run them:
Windows
```
.\mvnw.cmd test
```
Other platforms
```
./mnvw test
```

There is also a CI pipeline that uses Github Actions to run the tests automatically

## Known limitations
There was an attempt to handle better 404 errors with JSON response but I couldn't manage to make it.