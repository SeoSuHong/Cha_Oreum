CREATE TABLE member(
    id          VARCHAR(20)    NOT NULL,
    nickname    VARCHAR(20)    NOT NULL    UNIQUE,
    password    VARCHAR(20)    NOT NULL,
    email       VARCHAR(45)    NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE mainCategory(
    no      INT(11)        NOT NULL    AUTO_INCREMENT,
    name    VARCHAR(20)    NOT NULL,
    PRIMARY KEY(no)
);

CREATE TABLE subCategory(
    no                 INT(11)        NOT NULL    AUTO_INCREMENT,
    mainCategory_no    INT(11)        NOT NULL,
    name               VARCHAR(20)    NOT NULL,
    FOREIGN KEY(mainCategory_no) REFERENCES mainCategory(no),
    PRIMARY KEY(no)
);

CREATE VIEW subCategoryView
AS 
SELECT M.name mainCategory_name , S.* FROM subCategory S 
JOIN mainCategory M ON M.no = S.mainCategory_no;

CREATE TABLE post(
    no                 INT(11)        NOT NULL    AUTO_INCREMENT,
    member_nickname    VARCHAR(20)    NOT NULL,
    subCategory_no     INT(11)        NOT NULL,
    title              VARCHAR(50)    NOT NULL,
    contents           TEXT           NOT NULL,
    regDate            DATE           NOT NULL,
    fileName           VARCHAR(30),
    fileSize           INT(11),
    view               INT(11)        NOT NULL    DEFAULT 0,
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    FOREIGN KEY(subCategory_no) REFERENCES subCategory(no),
    PRIMARY KEY(no)
);

CREATE TABLE comment(
    no                 INT(11)          NOT NULL    AUTO_INCREMENT,
    post_no            INT(11)          NOT NULL,
    member_nickname    VARCHAR(20)      NOT NULL,
    contents           VARCHAR(1000)    NOT NULL,
    FOREIGN KEY(post_no) REFERENCES post(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
);

CREATE TABLE reply(
    no                 INT(11)          NOT NULL    AUTO_INCREMENT,
    comment_no         INT(11)          NOT NULL,
    member_nickname    VARCHAR(20)      NOT NULL,
    contents           VARCHAR(1000)    NOT NULL,
    FOREIGN KEY(comment_no) REFERENCES comment(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
);

CREATE TABLE hot(
    no           INT(11)        NOT NULL    AUTO_INCREMENT,
    member_id    VARCHAR(20)    NOT NULL,
    post_no      INT(11)        NOT NULL,
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(post_no) REFERENCES post(no),
    PRIMARY KEY(no)
);