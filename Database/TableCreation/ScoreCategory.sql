Create Table scoreCategory (
    scoreID int NOT NULL AUTO_INCREMENT,
    userID varchar(255) NOT NULL,
    score int(10) NOT NULL,
    categoryID int(10) NOT NULL,
    UNIQUE(scoreID),
    PRIMARY KEY(scoreID, userID),
    Index(scoreID),
    Foreign Key (categoryID) References categories(categoryID),
    Foreign Key (userID) References users(userID)
);