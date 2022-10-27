CREATE TABLE member(
    id          VARCHAR(20)     NOT NULL,
    nickname    VARCHAR(20)     NOT NULL    UNIQUE,
    password    VARCHAR(100)    NOT NULL,
    email       VARCHAR(45)     NOT NULL,
    role        VARCHAR(10)     NOT NULL,
    joindate	DATE			DEFAULT (CURRENT_DATE),
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

CREATE TABLE post(
    no                 INT(11)        NOT NULL    AUTO_INCREMENT,
    member_id    VARCHAR(20)    NOT NULL,
    subCategory_no     INT(11)        NOT NULL,
    title              VARCHAR(50)    NOT NULL,
    contents           LONGTEXT       NOT NULL,
    regDate            DATETIME       NOT NULL    DEFAULT NOW(),
    fileName           VARCHAR(100),
    fileSize           VARCHAR(100),
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(subCategory_no) REFERENCES subCategory(no),
    PRIMARY KEY(no)
);

CREATE TABLE comment(
    no                 INT(11)          NOT NULL    AUTO_INCREMENT,
    post_no            INT(11)          NOT NULL,
    member_nickname    VARCHAR(20)      NOT NULL,
    contents           VARCHAR(1000)    NOT NULL,
    regDate            DATETIME         NOT NULL    DEFAULT NOW(),
    FOREIGN KEY(post_no) REFERENCES post(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
);

CREATE TABLE reply(
    no                 INT(11)          NOT NULL    AUTO_INCREMENT,
    comment_no         INT(11)          NOT NULL,
    member_nickname    VARCHAR(20)      NOT NULL,
    contents           VARCHAR(1000)    NOT NULL,
    regDate            DATETIME         NOT NULL    DEFAULT NOW(),
    FOREIGN KEY(comment_no) REFERENCES comment(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
);

CREATE TABLE view(
	ip         VARCHAR(20)    NOT NULL,
	post_no    INT(11)        NOT NULL,
	FOREIGN KEY(post_no) REFERENCES post(no),
	PRIMARY KEY(ip, post_no)
);

CREATE TABLE hot(
    no           INT(11)        NOT NULL    AUTO_INCREMENT,
    member_id    VARCHAR(20)    NOT NULL,
    post_no      INT(11)        NOT NULL,
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(post_no) REFERENCES post(no),
    PRIMARY KEY(no)
);

CREATE TABLE notice(
	no          INT(11)        NOT NULL    AUTO_INCREMENT,
	admin_id    VARCHAR(20)    NOT NULL,
	title       VARCHAR(50)    NOT NULL,
	contents    TEXT           NOT NULL,
	regDate     DATE           NOT NULL    DEFAULT (CURRENT_DATE),
	FOREIGN KEY(admin_id) REFERENCES member(id),
	PRIMARY KEY(no)
);

CREATE TABLE noticeComment(
	no                 INT(11)          NOT NULL    AUTO_INCREMENT,
    notice_no          INT(11)          NOT NULL,
    member_nickname    VARCHAR(20)      NOT NULL,
    contents           VARCHAR(1000)    NOT NULL,
    regDate            DATETIME         NOT NULL    DEFAULT NOW(),
    secret             BIT(1)           NOT NULL    b'0',
    FOREIGN KEY(notice_no) REFERENCES notice(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
)

CREATE TABLE noticeReply(
	no                  INT(11)          NOT NULL    AUTO_INCREMENT,
	notice_no           INT(11)          NOT NULL,
    comment_no          INT(11)          NOT NULL,
    member_nickname     VARCHAR(20)      NOT NULL,
    contents            VARCHAR(1000)    NOT NULL,
    regDate             DATETIME         NOT NULL    DEFAULT NOW(),
    secret              BIT(1)           NOT NULL    b'0',
    FOREIGN KEY(notice_no) REFERENCES notice(no),
    FOREIGN KEY(noticeComment_no) REFERENCES noticeComment(no),
    FOREIGN KEY(member_nickname) REFERENCES member(nickname),
    PRIMARY KEY(no)
)