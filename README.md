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
    docker run -d name shopping-postgres \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=password \
    -e POSTGRES_DB=shoppingdb   \
    -p 5432:5432 \
    postgres:14.4
```