# Insurance Demo
## Description
This application is a solution to a task where I was required to run 3 separate application and make them communicate with each other.


## Startup
1. Install maven
2. Start the client:
```
cd src/main/React
npm install
npm start
```

3. Start the integration layer.
In the root of the application, run: 
```
mvnw spring-boot:run
```
I believe Mac requires 
```
mvn spring-boot:run
```

This starts the integration layer.

4. Lastly start the Server:
Do this by running the main class here:
```
src/main/java/com/subjectsystem/Server.java
```

Now, by accessing `http://localhost:3000` you should be able to run the application.

## Requirements
- JDK 11
- Maven
- NPM
