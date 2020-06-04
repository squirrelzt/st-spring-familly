DROP TABLE IF EXISTS user;
CREATE TABLE user  (
  id int IDENTITY,
  name varchar(50) ,
  age int,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  creator varchar(50),
  updator varchar(50),
  version varchar(30)
)

