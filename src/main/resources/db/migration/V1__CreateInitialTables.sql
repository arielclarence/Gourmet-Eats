
CREATE TABLE `user`
(
    id int NOT NULL AUTO_INCREMENT,
    name   varchar(255) NOT NULL,
    username   varchar(255) NOT NULL,
    password_hash   varchar(255) NOT NULL,
    phonenumber   varchar(255) NOT NULL,
    email   varchar(255) NOT NULL,
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
    seller_id  int NOT NULL,
    name       varchar(50) NOT NULL,
    code       varchar(50) NOT NULL,
    description varchar(200),
    pictureUrl       varchar(255) NOT NULL,
    totalsales   int NOT NULL,
    status boolean NOT NULL ,
    cuisine_id int NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (code),
    FOREIGN KEY (seller_id) REFERENCES user (id),
    FOREIGN KEY (cuisine_id) REFERENCES cuisine (id)
);
CREATE TABLE `chat`
(
    id int NOT NULL AUTO_INCREMENT,
    customer_id int NOT NULL,
    seller_id int NOT NULL,
    updatedAt timestamp NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES `user` (id),
    FOREIGN KEY (seller_id) REFERENCES `user` (id)
);

CREATE TABLE `message`
(
    id int NOT NULL AUTO_INCREMENT,
    sender_id int NOT NULL,
    content varchar(255) NOT NULL,
    timestamp timestamp NOT NULL,
    chat_id int NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (sender_id) REFERENCES `user` (id),
    FOREIGN KEY (chat_id) REFERENCES chat (id)
);

