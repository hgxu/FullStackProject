# FullStackProject

### Reference Documentation

* Rest Service is built with Spring Boot: https://spring.io/quickstart
* Gradle is used as build automation: https://gradle.org/install/
* Rest Assured is the used for API test automation: https://rest-assured.io/
* Dockerfile in the project for build docker image: https://docs.docker.com/engine/reference/builder/
* Jenkinsfile is included but mixed with part of sudo code for trigger automation etc.

### Execution Guides Run Locally

* cd FullStackProject
* Build jar file: ./gradlew build
* Build docker image: docker build --build-arg JAR_FILE=build/libs/*.jar -t fullstackproject:2.0 .
* Start server: docker run -p 8080:8080 -t fullstackproject:2.0

### Test
* Automation test framework: 
* Health Check: http://localhost:8080/health
* Help: http://localhost:8080/help
