drop table if exists messages;
create table
  messages(
    # determine message when we update it
    id int unsigned primary key auto_increment,

    # the content of each message
    content varchar(500) not null,

    # the author name
    user_name char(20) not null,

    create_datetime datetime
      default current_timestamp not null,
    update_datetime timestamp
      default current_timestamp not null
      on update current_timestamp
  )engine = InnoDB default charset = utf8;

select * from messages;

select id,content,user_name,
       create_datetime,
       update_datetime
from messages limit 10;

insert into
  messages(content, user_name)
  values (
    'hello world, this is first message',
    'Jon');