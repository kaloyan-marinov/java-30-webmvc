# run the application from the command line with ... Maven

```shell
$ ./mvnw spring-boot:run
```

(Either use a web browser or)
Use another terminal window to issue these HTTP request:
```shell
$ curl localhost:8080/greeting \
    | json_pp
# ...
{
   "content" : "Hello, World!",
   "id" : 1
}



$ curl 'localhost:8080/greeting?name=Mary' \
    | json_pp
# ...
{
   "content" : "Hello, Mary!",
   "id" : 2
}

# Notice also how the `id` attribute has changed from `1` to `2`.
# This proves
# that you are working against the same `GreetingController` instance across multiple requests
# and
# that its `counter` field is being incremented on each call as expected.
```

# build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that

build the JAR file with
```shell
./mvnw clean package
```

run the JAR file, as follows:
```
java \
    -jar target/tutorial-about-java-30-0.0.1-SNAPSHOT.jar
```

Issue the above-mentioned HTTP request (either via a web browser or via `curl`).
