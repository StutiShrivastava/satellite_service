## SolenixService
Service Component for Solenix to handle the service layers example RESTful service for managing satellite events.

To execute this SpringBootApplication run Application.java main class, it will automatically start the application on embedded Apache Tomcat and Oracle Database

Application class is the main entry point of this SpringBoot Application. 
Execute the main method to run the application on embedded Tomcat Server and in-memory H2 database.

Postman(Chrome Plugin) to test below REST API's - https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop/related?hl=en 

General perturbations orbital data GP Data (aka TLEs: Two-Line Element Sets)


// Use DBML to define your database structure. Docs: https://dbml.dbdiagram.io/docs
// dbdiagram.io provides user-friendly interface to design and visualize ER diagram.
// Use your Java Entity class to map the variable names and its datatype.
// Use the RelationShip mentioned in the Entity class to mention the Ref:

// SolenixService ER Diagram - https://dbdiagram.io/d/667312605a764b3c72e83ed3

Table Satellite {
  Satellite_Id Long [primary key]
  name String
}

Table Event {
  Event_id Long [primary key]
  event_date Date 
  description String
  priority String
  Satellite_Id Long 
}

Table TLEInformation {
  Tle_information_id Long [primary key]
  last_Update_Date Date 
  line1 String
  line2 String
  Satellite_Id Long 
}

 Ref: Event.Satellite_Id > Satellite.Satellite_Id // many-to-one
 Ref: TLEInformation.Satellite_Id - Satellite.Satellite_Id // one-to-one
 
 
 
 To run complete app together using docker compose--> 
1. download the docker-compose.yml
2. Ensure Docker desktop is running on the system. 
3. Navigate to the folder, open a teminal and run the below command. 
> docker-compose up -d
4. To view the images , run below command
> docker images
   This should diplay newly created images
5. To view the conatainers 
> docker ps
    This should display the running conatiners
   

Web App Url:
http://localhost:3000/home


Service Urls:
 1. For list of events:
 http://localhost:8282/api/events/list
 
 2. For creation of events:
 http://localhost:8282/api/events/create
 
 3. For getting event for specific satellite
 http://localhost:8282/api/events/satellite/{name}
 
 
 **Note - Replace localhost with your hostname
 
 
 Codebase Service -
 https://github.com/StutiShrivastava/satellite_service
 
  Codebase WebApp -
 https://github.com/StutiShrivastava/satellite_app
 
 
 Link to the Docker Images 
 stutishrivastava/solenixwebapp:latest
https://hub.docker.com/layers/stutishrivastava/solenixwebapp/latest/images/sha256-48143dea1ee93603d09f80a4c300cb8577703f77a27fa5a90128771a633859a5?context=repo


stutishrivastava/solenixservice:latest
https://hub.docker.com/layers/stutishrivastava/solenixservice/latest/images/sha256-adae5711e5f700d367849d2b72be14a21783a3a0c24417f7f31aec216dfcb840?context=repo