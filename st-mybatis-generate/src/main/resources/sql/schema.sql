
create table t_coffee (
    id bigint not null ,
    name varchar(255),
    price bigint not null,
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);

create table school (
    id int NOT NULL ,
    name char(40) DEFAULT NULL,
    address char(200) DEFAULT NULL,
    teacher_count int DEFAULT NULL,
    student_count int DEFAULT NULL
);