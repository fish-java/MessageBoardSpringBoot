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

docker run --rm -p 8081:8080 -e Message_board_password=926443\
message-board mvn exec:java

git clone ..

docker run --rm -p 8081:8080 -v /root/docker/MessageBoard:/app -it maven:3.6.0 bash

export Message_board_password=926443

mvn install
mvn exec:java

因为为了安全，数据库密码是从shell env中动态读取的
所以可
要
export Message_board_password=926443
$ echo $Message_board_password


