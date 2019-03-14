# REST API
This is a documentation of REST API for our message
board.

You should read this before you use it.

When you try to post or edit a message, you have to 
add a authorization token on request header.

Such as
```
Authorization: bearer sdfewsadfewasfe
```

If you don't provide a validate token, you will 
get a `403 Forbidden`.

If you don't have a token, you should generate a
to form [here](./users.md).


## Documentation style

-----

# Title
- content1
- content2

## Content1 detail
_Additional information about this API call._

### URL
_The URL Structure (path only, no root url)_

### QueryString
_some params set on url_

### Header
_request headers structure_

### Body
_request body structure_

### Response
```
Response Status
```
```
Response body
```

