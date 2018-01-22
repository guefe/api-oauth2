# api-oauth2

Gradle-based project.

It is necesary to install gradle before executing the project (https://gradle.org/install/).

Once gradle and Java 8 have been corretly installed, move to project's folder and execute:
```` bash
gradle bootRun
````

Server will start in http://localhost:8080/api/. The project provides a Swagger interface to test the API methods.

In order to get a valid token:
````bash
curl api:api-secret@localhost:8080/api/oauth/token -d grant_type=password -d username=user@user.com -d password=user123
curl api:api-secret@localhost:8080/api/oauth/token -d grant_type=password -d username=admin@admin.com -d password=admin123
````
