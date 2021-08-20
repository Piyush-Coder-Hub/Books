
CREATE TABLE testDB.book(
    book_id int,
    bookName varchar(255),
    page varchar(255),
    book_auth_id int,
	PRIMARY KEY (book_id),
    FOREIGN KEY (book_auth_id) REFERENCES author(author_id) 
);
CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
);
CREATE TABLE testDB.author(
    author_id int,
    author_Name varchar(255),
    PRIMARY KEY (author_id)
    );


drop table testDB.book;

CREATE TABLE testDB.author(
    author_id int,
    author_Name varchar(255),
    page varchar(255),
	    PRIMARY KEY (author_id)

);
commit;

alter table testDB.book modify column book_id int NOT NULL AUTO_INCREMENT;

alter table testDB.author modify column author_id int NOT NULL AUTO_INCREMENT;
insert into testDB.author(author_id,author_name)
VALUES (1, 'bbc');

insert into testDB.author(author_id,author_name)
VALUES (2, 'aah');


INSERT INTO testDB.book (book_id,bookName,page,book_auth_id)
VALUES (1, 'Tom B. Erichsen', 25,1);
INSERT INTO testDB.book (book_id,bookName,page,book_auth_id)
VALUES (2, 'iio', 6,2);
