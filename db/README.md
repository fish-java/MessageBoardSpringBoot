# Tables of Database
before we begin to developer our webapp, 
we have to design our database first.

This is our tables.

## Messages
we need a table to store messages, each 
message should has follow fields:

- `messages`: table name.
  - `id`: we should give each message a
    unique id.
  - `content`: the content of a message.
    500 character is enough to store a message.
  - `user_name`: refer to user who create
    this message
    
  - `create_datetime`: store the datetime
    when this message is create.
  - `update_datetime`: last modify datetime.
  
## Users
- `users`: to store user information.

  - `user_name` user's name 
  - `password`
  - `token`
  
## SQL
Also, I add some SQL you may use in future.
