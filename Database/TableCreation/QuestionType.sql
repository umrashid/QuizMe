Create Table QuestionType (
    questionTypeID int NOT NULL AUTO_INCREMENT,
    questionType varchar(255) NOT NULL,
    UNIQUE(questionTypeID),
    Index(questionTypeID)
);