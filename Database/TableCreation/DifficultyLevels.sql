Create Table DifficultyLevels (
    difficultyID int NOT NULL AUTO_INCREMENT,
    difficultyLevel varchar(255) NOT NULL,
    UNIQUE(difficultyID),
    Index(difficultyID)
);