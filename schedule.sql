create schema calendar;

create table schedule (
    id BIGINT auto_increment primary key,
    userName varchar(50),
    title varchar(50),
    contents varchar(255),
    createDatetime timestamp,
    updateDatetime timestamp
);

create table user (
    id BIGINT AUTO_INCREMENT primary key,
    name varchar(50),
    email varchar(50),
    createDateTime timestamp,
    updateDateTime timestamp
);

alter table schedule
    drop column user_name;
alter table schedule
    modify userId bigint;
alter table schedule
    add constraint fkUserId
        foreign key (userId)
        references user(id);


