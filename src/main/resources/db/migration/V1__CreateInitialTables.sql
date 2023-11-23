
CREATE TABLE `user`
(
    id int NOT NULL AUTO_INCREMENT,
    name   varchar(255) NOT NULL,
    username   varchar(255) NOT NULL,
    password_hash   varchar(255) NOT NULL,
    phonenumber   varchar(255) NOT NULL,
    address   varchar(255) NOT NULL,
    gender   varchar(255) NOT NULL,
    image   varchar(255),
    birthdate   date NOT NULL,
    balance   int NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (username)

);
CREATE TABLE cuisine
(
    id   int     NOT NULL AUTO_INCREMENT,
    name varchar(50),
    PRIMARY KEY (id),
    UNIQUE (name)
);
CREATE TABLE food
(
    id         int NOT NULL AUTO_INCREMENT,
    seller_id   int NOT NULL,
    name       varchar(50) NOT NULL,
    code       varchar(50) NOT NULL,
    description varchar(200),
    image       varchar(255) NOT NULL,
    totalsales   int NOT NULL,
    status boolean NOT NULL ,
    cuisine_id int NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (code),
    FOREIGN KEY (seller_id) REFERENCES user (id),
    FOREIGN KEY (cuisine_id) REFERENCES cuisine (id)


);


