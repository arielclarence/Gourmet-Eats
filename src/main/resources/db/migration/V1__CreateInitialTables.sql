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
    FOREIGN KEY (seller_id) REFERENCES cuisine (id),
    FOREIGN KEY (cuisine_id) REFERENCES cuisine (id)


);