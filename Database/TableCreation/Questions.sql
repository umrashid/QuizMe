Create Table Question (
    questionID int NOT NULL AUTO_INCREMENT,
    question varchar(1000) NOT NULL,
    correct varchar(255) NOT NULL,
    option1 varchar(255) NOT NULL,
    option2 varchar(255) NOT NULL,
    option3 varchar(255) NOT NULL,
    categoryID int NOT NULL,
    difficultyID int NOT NULL,
    questionTypeID int NOT NUlL,
    ImagePath varchar(1000),
    UNIQUE(questionID),
    PRIMARY KEY (questionID),
    INDEX(questionID),
    Foreign Key (categoryID) References categories(categoryID),
    Foreign Key (difficultyID) References difficultylevels(difficultyID),
    Foreign Key (questionTypeID) References questionType(questionTypeID)
);