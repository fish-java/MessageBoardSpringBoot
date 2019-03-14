# Users
- create a user
- get a new token

## Create a user
### URL
```
POST /users
```
### Body
- `username`

  a string, user's name
  
- `password`

  a string, user's password
#### example
```json
{
  "username": "Jack",
  "password": "123456"
}
```

### Response
```
Status: 201 Created
```
```json
{
  "user_name": "Jack",
  "token": "acsewdsfsdfsdews"
}
```

## Generate a new token
get a new token, old token will be nvalidation.

### URL
```
PATCH /users/:username/token
```
### Body
- `username`

  a string, user's name
  
- `password`

  a string, user's password
#### example
```json
{
  "username": "Jack",
  "password": "123456"
}
```
### Response
```
Status: 200 OK
```
```json
{
  "user_name": "Jack",
  "token": "wesfesdfsae"
}
```
