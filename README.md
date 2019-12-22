# Course: [Udemy - Spring Core - Learn Spring Framework 4 and Spring Boot](https://www.udemy.com/course/spring-core/learn/lecture/4490768#overview)
# Instructor: John Thompson - SpringFrameworkGury

Project: 08_JPA_ DAO_service

Project Description:

Using Pure JPA, i've taken the previous project and created a DAO around an Entity Manager for both the product and customer services.

Pure JPA is used here to persist data into the h2 and memory database using CRUD operations.

I created a bootscrap properties file that allowed me to prepoulate the database when the spring context is started or refreshed.
Thus allowing me to have the services active and makes things easier when it comes to testing.

I created JPA intergration tests using spring and jUnit. Using Hibernate, and the a prebuilt database, I setup spring boot auto configuration, create a configuration class in java, 
and in the jUnit test I call in that configuration which enables the h2 database and hibernate, then inject the jpaimplimentation into the jUnit test, add the entity manager and test based on this configuration.

