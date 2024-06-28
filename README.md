
## Running Locally
To run locally, in IntelliJ IDEA, go to run configurations and add <b>VM options</b> 
where you can set `` -Dspring.profiles.active=local ``. Make sure you have
created Postgres database named  ``shoppingdb`` on your local PostgreSQL database instance, before
you run shopping-service locally, otherwise PSQL Exception will be thrown.
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

## Running Services as containers
Before you run docker commands to create the services and get them up and running
make sure you create docker network. Docker has a built-in DNS server that can enable containers <br/>
in the same network to find each other using the container name rather than a hostname or an IP
address.  To create docker network: <br/>
``` docker network create shopping-network```

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
    --net shopping-network \
    -p 8081:8081 \
    -e SPRING_DATASOURCE_URL=jdbc:postgresql://shopping-postgres:5432/shoppingdb \
    -e SPRING_PROFILES_ACTIVE=testdata \
    shopping-service
```

### To delete the containers after you are done: <br/>
``` 
docker rm -f catalog-service polar-postgres
```
