Create Table scoreDifficulty (
    scoreID int NOT NULL AUTO_INCREMENT,
    userID varchar(255) NOT NULL,
    score int(10) NOT NULL,
    difficultyID int(10) NOT NULL,
    UNIQUE(scoreID),
    PRIMARY KEY(scoreID, userID),
    Index(scoreID),
    Foreign Key (difficultyID) References difficultylevels(difficultyID),
    Foreign Key (userID) References users(userID)
);