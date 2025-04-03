create schema calendar;

create table schedule (
    id BIGINT auto_increment primary key,
    userName varchar(50),
    title varchar(50),
    contents varchar(255),
    createDatetime timestamp,
    updateDatetime timestamp
);