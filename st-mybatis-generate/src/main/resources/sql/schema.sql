
create table t_coffee (
    id bigint not null auto_increment,
    name varchar(255),
    price bigint not null,
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);

create table school (
    id int(11) NOT NULL AUTO_INCREMENT,
    name char(40) DEFAULT NULL,
    address char(200) DEFAULT NULL,
    teacher_count int(10) DEFAULT NULL,
    student_count int(10) DEFAULT NULL
)