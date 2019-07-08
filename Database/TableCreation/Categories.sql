Create Table Categories (
    categoryID int NOT NULL AUTO_INCREMENT,
    CategoryName varchar(255) NOT NULL,
    UNIQUE(categoryID),
    Index(categoryID)
);