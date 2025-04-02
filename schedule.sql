create schema calendar;

create table schedule (
    id BIGINT auto_increment primary key,
    name varchar(50),
    email varchar(50),
    createDatetime timestamp,
    updateDatetime timestamp
);