drop table if exists users;
create table
  users(
    # name and password
    user_name char(20) primary key,
    password char(30) not null,

    # identify user with token
    token char(30) not null,

    # addition information
    birthday date default null,
    phone int default null,
    email char(30) default null,

    create_datetime datetime
        default current_timestamp not null
  ) engine=InnoDB default charset=utf8;
desc users;

ALTER TABLE users
  Change phone phone_number int;

insert into
  users(user_name, password, token)
  values(
    'Jack',
    '123456',
    'safesedese');

select * from users;

PREPARE createUser
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';

# 设置三个变量，然后来填充它
SET @a = 'AAAA';
SET @b = '132131';
SET @c = 'bbc';
EXECUTE createUser USING @a, @b, @c;

DEALLOCATE PREPARE createUser;

PREPARE testMutipStatement1
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';

# 设置三个变量，然后来填充它
SET @a1 = 'Test1';
SET @b1 = '132131';
SET @c1 = 'bbc';

PREPARE testMutipStatement2
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';

# 设置三个变量，然后来填充它
SET @a2 = 'Test2';
SET @b2 = '132131';
SET @c2 = 'bbc';

EXECUTE testMutipStatement1 USING @a1, @b1, @c1;

EXECUTE testMutipStatement2 USING @a2, @b2, @c2;

# 既然同一个连接可以创建对个statement，为什么我们还需要创建连接池？？


delete from users where user_name = 'Test2';



SET @a1 = 'Test2222';
SET @b1 = '132131';
SET @c1 = 'bbc';

PREPARE testMutipStatement2
  FROM 'insert into users(
          user_name, password, token)
        VALUE (?, ?, ?)';

# 设置三个变量，然后来填充它
SET @a1 = 'Test2';
SET @b2 = '132131';
# SET @c2 = 'bbc';

EXECUTE testMutipStatement1 USING @a1, @b1;