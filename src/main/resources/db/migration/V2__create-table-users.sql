create table users (
    id bigint not null AUTO_INCREMENT,
    name varchar(100) not null unique,
    email VARCHAR(100) not null unique,
    password varchar(100) not null,
    profiles varchar(300),

    primary key (id)
);