# Spring Data MongoDb - REST API

## Description
This project is a Spring Boot application that demonstrates basic operations on two collections Applicants. It uses Spring Data MongoDB to interact with MongoDB database hosted on Atlas.

## Technologies Used
- **Spring Boot**: Framework for creating REST APIs and web applications.
- **Spring Data MongoDB**: To interact with the MongoDB database in an easy and effective way.
- **MongoDB**: Database hosted online via Atlas Cloud Server.

## Steps
### Building Spring Boot application with MongoDB AWS cloud database

1. **Generate a project template** from [Spring Initializr](https://start.spring.io/) with the following dependencies:
    - Spring Boot DevTools
    - Spring Web
    - Spring Data MongoDB

2. **Create sub-packages under the main package** for:
    - `models` (for mapping classes)
    - `repositories` (for CRUD support)
    - `services` (for business logic)

3. **Add connectivity parameters** to the `application.properties` file:
    ```
    spring.data.mongodb.uri=Your URL
    spring.data.mongodb.database=Your database name
    ```

4. **Create a model class** (similar to the Entity class in JPA):
    ```java
    @Document(collection="applicants")
    public class Applicant {
        @Id
        private int id;
        private String name;
        private String role;
        private String qualification;
        private int experience;
        private List<String> skills;
        private String mobile;
        private String applydate;
    }
    ```

5. **Create a Repository interface**:
    ```java
    package com.sharayu.awsmongocrud.repositories;

    import org.springframework.data.mongodb.repository.MongoRepository;
    import com.sharayu.awsmongocrud.models.Applicant;

    public interface ApplicantRepository extends MongoRepository<Applicant, Integer> {
    }
    ```

6. **Create a services class** to perform various operations on the data:
    ```java
    @Service
    public class ApplicantServices {
        @Autowired
        private ApplicantRepository apprepo;

        public List<Applicant> getAllApplicants() {
            return apprepo.findAll();
        }

        public Applicant addNewApplicant(Applicant a) {
            Calendar cal = Calendar.getInstance();
            a.setApplydate(cal.getTime().toString());
            return apprepo.save(a);
        }
    }
    ```

7. **Create controller methods** to expose end-points of the REST API:
    ```java
    @RestController
    public class MongoController {
        @Autowired
        private ApplicantServices appserv;

        @GetMapping("/allapps")
        public List<Applicant> getAllApps() {
            return appserv.getAllApplicants();
        }

        @PostMapping("/addapp")
        public Applicant addApp(@RequestBody Applicant a) {
            return appserv.addNewApplicant(a);
        }
    }
    ```

8. **Now try calling requests on Postman**. I have tried it and shared the screenshots as output:
    - **PostRequest**
      ![InsertMongo](https://github.com/user-attachments/assets/a3b2ac0c-25f5-4513-82d3-1c86587bd01f)
      
    - **GetRequest**
     ![SelectMongo](https://github.com/user-attachments/assets/02b36d35-696c-419e-8382-b5e429989366)

    - **SearchRequest**
     ![SearchMongo](https://github.com/user-attachments/assets/4eff5e93-b2dc-4748-9a96-d5a979861dd7)


