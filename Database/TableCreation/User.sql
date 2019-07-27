Create Table users (
    userID varchar(255) NOT NULL,
    password varchar(10) NOT NULL,
    firstName varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    UNIQUE(userID),
    PRIMARY KEY (userID),
);
