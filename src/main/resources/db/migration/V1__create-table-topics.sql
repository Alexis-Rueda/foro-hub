create table topics(
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    message varchar(500) not null unique,
    creation_date DATETIME not null,
    status TINYINT,
    user_Id bigint NOT NULL,
    course_Id bigint NOT NULL,

    primary key (id)
);