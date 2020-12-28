# FullStackProject 

### Documentation and Reference

* Spring Boot framework is used for building the Restful file upload service, about Spring Boot: https://spring.io/quickstart
* Gradle is used as build automation, about Gradle: https://gradle.org/install/
* Rest Assured is the used for API test automation, about Rest Assured: https://rest-assured.io/
* Dockerfile is created for the project for build docker image, about Docker: https://docs.docker.com/engine/reference/builder/
* Jenkinsfile is included but mixed with part of sudo code for trigger automation etc. About Jenkins pipeline syntax: https://www.jenkins.io/doc/book/pipeline/syntax/

### Execution Guides locally

* cd FullStackProject
* Build jar file: ./gradlew build
* Build docker image: docker build --build-arg JAR_FILE=build/libs/*.jar -t fullstackproject:2.0 .
* Start server: docker run -p 8080:8080 -t fullstackproject:2.0


### Test
* Automation test framework: https://github.com/hgxu/TestFramework
* Health Check: http://localhost:8080/health
* Help: http://localhost:8080/help

