# Insurance Demo
## Description
This application is a solution to a task where I was required to run 3 separate application and make them communicate with each other.


## Startup
1. Install maven
2. cd into src/main/React and run:
```
npm install
npm start
```
This starts the client.

3. In the root of the application, run: 
```
mvnw spring-boot:run
```
I believe Mac requires 
```
mvn spring-boot:run
```

This starts the integration layer.

4. Lastly run the main class within:
```
src/main/java/com/subjectsystem/Server.java
```

Now, by accessing `http://localhost:3000` you should be able to run the application.

## Requirements
- JDK 11
- Maven
- NPM
