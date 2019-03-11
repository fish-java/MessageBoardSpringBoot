# 数据库设计

- messages
  - id
  - content varchar(300)
  - user_id int
  
  - create_datetime
  - update_datetime
  
- users

  - name primary key varchar(10)
  - password varchar(20)
  
users.name and messages.user_name
这样是否合理？
我觉得两者还是相同为好，虽然对users表来说
前缀是多余的

互联网企业场景一般不用外键