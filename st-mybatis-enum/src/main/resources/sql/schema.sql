DROP TABLE IF EXISTS person;
create table person (
    id bigint not null auto_increment,
    name varchar(255),
    age int not null,
    gender varchar(10) not null,
    zip_code int(10),
    primary key (id)
);

