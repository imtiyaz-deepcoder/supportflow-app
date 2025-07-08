# Customer Support - Ticket Resolution App (SupportFlow)

This is a full-stack customer support system with Spring Boot backend and React frontend.

## Part 1: Spring Boot Setup + MySQL Integration + Ticket Model 

This branch contains:
- Spring Boot project setup via Spring Initializr
- MySQL database connection
- Ticket model class

### How to Run
1. Clone the branch:
   ```bash
   git clone -b v1-project-setup-dbconnect-model-class https://github.com/yourusername/supportflow-app.git
2. Update DB credentials in application.properties
3. Run using
   ``` from terminal/cmd
   ./mvnw spring-boot:run

# General app.props template

#DB Connection Settings
spring.datasource.username=
spring.datasource.password=
spring.datasource.url=jdbc:db-variant://serverurl:portno/<db-name>?createDatabaseIfNotExist=true
#Hibernate Settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.<DB>


Ticket Model class
    private Long id;
    private String subject;
    private String description;
    private String status; // OPEN, IN_PROGRESS, CLOSED
    private String priority; // LOW , MEDIUM, HIGH
    private String customerUsername; // who created
    private LocalDate createdAt; //date of creation
    private String response; // exec reply
    private LocalDate resolvedAt; //date of resolve
    private String resolvedBy; //who resolved it



Next Video / Branch 
v2-rest-api 

