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
    drop column username;
alter table schedule
    add userId bigint;
alter table schedule
    add constraint fkUserId
        foreign key (userId)
        references user(id);
alter table user
    add column password varchar(50);
alter table user
    modify column email VARCHAR(50) NOT NULL UNIQUE,
    modify column password varchar(50) not null;

