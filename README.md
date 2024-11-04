# Space Central

Space Central Limited, based in Tbilisi, specializes in a variety of 
customer services including online shopping platform called space
shopping.

## Business Goals
Space Central aims to create a platform that's dependable, user-friendly,
and accessible to anyone at any time and place. The application
must handle millions of concurrent users without compromising service
quality.

## Shopping Service
To run the tests open the terminal in shopping-service folder and run: <br/>
``` ./gradlew test ``` <br/>
To package the application as a container image: <br/>
``` ./gradlew bootBuildImage ``` <br/>
To run the image: <br/>
``` docker run  --rm --name shopping-service  -p 8080:8080 shopping-service:0.0.1-SNAPSHOT ``` <br/>
<b> --rm </b> removes the container after its execution completes. <br/>
To start minikube: <br/>
``` minikube start --driver=docker ``` <br/>
To manually import the image to the kubernetes cluster: <br/>
``` minikube image load shopping-service:0.0.1-SNAPSHOT ``` <br/>
To create deployment: <br/>
``` kubectl create deployment shopping-service --image=shopping-service:0.0.1-SNAPSHOT ``` <br/>

## Running Postgres as a Container
``` 
    docker run -d --name shopping-postgres \
    --net shopping-network \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=password \
    -e POSTGRES_DB=shoppingdb   \
    -p 5432:5432 \
    postgres:14.4
```

## Running Shopping Service as a Container
``` 
    docker run -d --name shopping-service \
    --net shopping-service \
    -p 8081:8081 \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://shopping-postgres:5432/shoppingdb \
    -e SPRING_PROFILES_ACTIVE=testdata \
    shopping-service
```

### To delete the containers after you are done: <br/>
``` 
docker rm -f catalog-service polar-postgres
```
