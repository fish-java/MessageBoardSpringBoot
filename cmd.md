## For command line user
```bash
$ mvn clean
$ mvn test
$ mvn install
$ mvn exec:java
```

## For docker
``` bash
$ docker build -t message-board .

# for Chinese user
$ docker build -t message-board -f Dockerfile.cn .


docker run --rm -p 8081:8080 -e Message_board_password=YOU_PASSWORD\
message-board mvn exec:java
```