# RESTful API
basic path for all request
```
/api
```
this is the basic path for all request
不需要的，这样写局限性比较大，就用
二级域名吧

## messages

### list messages
list all messages

```
GET /messages
```
```
Status: 200 OK
```
```json
[
  {
    "id": 2,
    "content": "first message",
    "user_name": "Jack",
    "create_datetime": "2019-03-11 08:52:42",
    "update_datetime": "2019-03-11 08:52:42"
  }
]
```


## users
### create a user
Request
```
POST /users
```
Request Headers
```
user_name: Jack
password: 123456
```
Response when create success
```
Status: 200 OK
```
```json
{
  "user_name": "Jack",
  "token": "acsewdsf"
}
```
user_name required
password_required

404 when failed
```
Status: 200 OK
```
```json
{
  "user_name": "Jack",
  "token": "acsewdsf"
}
```
到底是user_name 还是 username?
一个是习惯的创建用户的方法
一个是数据库的字段
username 把，辛苦一下后端就行了
### get token
Request
```
GET /user/token
```
Request Headers
```
username: Jack
password: 123456
```
Response
```
Status: 200 OK
```
```json
{
  "username": "Jack",
  "token": "acsewdsf"
}
```

