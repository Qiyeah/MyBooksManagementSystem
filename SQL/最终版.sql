CREATE TABLE Users (

user_ID CHAR(32) NOT NULL,

user_Name VARCHAR2(20) NULL,

user_Pass VARCHAR2(20) NULL,

user_Money NUMBER(7,2) NULL,

user_Phone VARCHAR2(15) NULL,

user_EMail VARCHAR2(20) NULL,

user_State INT NULL,-- 用户状态 1001051028

PRIMARY KEY (user_ID) 

);



COMMENT ON COLUMN Users.user_State IS '状态用来限制是否可以借阅';



CREATE TABLE Books (

bk_ID CHAR(32) NOT NULL,-- 书ID

bk_Name VARCHAR2(50) NULL,--书名

bk_Author VARCHAR2(30) NULL,--作者

bk_Price NUMBER(7,2) NULL,

bk_Count INT NULL,

bk_State int,

bt_ID CHAR(32) NULL,

PRIMARY KEY (bk_ID) 

);



CREATE TABLE BookType (

bt_ID CHAR(32) NOT NULL,

bt_Name VARCHAR2(20) NULL,--类型名

bt_RID CHAR(32) NULL, --类型关联ID

bt_Time int,--借阅时间 周

PRIMARY KEY (bt_ID) 

);



CREATE TABLE Borrow (--借阅记录

br_ID CHAR(32) NOT NULL,--借阅批次ID

user_ID CHAR(32) NULL,--借阅者ID

bt_date DATE NULL,--借阅时间

PRIMARY KEY (br_ID) 

);



CREATE TABLE BorrowInfo (--借阅详情

bri_ID CHAR(32) NOT NULL,--借阅详情ID

br_ID CHAR(32) NULL,--借阅批次ID

bk_ID CHAR(32) NULL,--借阅的书籍ID

bri_State int,--借阅状态，没有还为1，已还为0
PRIMARY KEY (bri_ID) 

);



CREATE TABLE SendBack (--还书记录

sdb_ID CHAR(32) NOT NULL,

user_ID CHAR(32) NULL,

sdb_date DATE NULL,

PRIMARY KEY (sdb_ID) 

);



CREATE TABLE SendBackInfo (

stbi_ID CHAR(32) NOT NULL,

sdb_ID CHAR(32) NULL,

bk_ID CHAR(32) NULL,

PRIMARY KEY (stbi_ID) 

);



CREATE TABLE BookComments (--书评

bc_ID CHAR(32) NOT NULL,--书评ID

user_ID CHAR(32) NULL,--评论人

bk_ID CHAR(32) NULL,--被评论书

bc_Comment varchar2(2000) NULL,--评论内容

bc_Date DATE NULL,--评论时间

PRIMARY KEY (bc_ID) 

);



CREATE TABLE lostBooks (

lb_ID CHAR(32) NOT NULL,

bk_ID CHAR(32) NULL,

user_ID CHAR(32) NULL,

lb_Date DATE NULL,

PRIMARY KEY (lb_ID) 

);



CREATE TABLE admins (

ad_ID CHAR(32) NOT NULL,

ad_Name VARCHAR2(30) NULL,

ad_Pass VARCHAR2(30) NULL,

ad_state INT NULL,

PRIMARY KEY (ad_ID) 

);



CREATE TABLE BooksAddInfo (

bka_ID CHAR(32) NOT NULL,

ad_ID CHAR(32) NULL,

bk_ID CHAR(32) NULL,

bka_Date DATE NULL,

PRIMARY KEY (bka_ID) 

);



CREATE TABLE BooksDownInfo (

bkd_ID CHAR(32) NOT NULL,

ad_ID CHAR(32) NULL,

bk_ID CHAR(32) NULL,

bkd_Date DATE NULL,

PRIMARY KEY (bkd_ID) 

);





ALTER TABLE Books ADD CONSTRAINT fk_books_Btype FOREIGN KEY (bt_ID) REFERENCES BookType (bt_ID);

ALTER TABLE BorrowInfo ADD CONSTRAINT fk_bri_br FOREIGN KEY (br_ID) REFERENCES Borrow (br_ID);

ALTER TABLE BorrowInfo ADD CONSTRAINT fk_bri_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);

ALTER TABLE Borrow ADD CONSTRAINT fk_br_us FOREIGN KEY (user_ID) REFERENCES Users (user_ID);

ALTER TABLE SendBack ADD CONSTRAINT fk_sdb_us FOREIGN KEY (user_ID) REFERENCES Users (user_ID);

ALTER TABLE SendBackInfo ADD CONSTRAINT fk_stbi_stb FOREIGN KEY (sdb_ID) REFERENCES SendBack (sdb_ID);

ALTER TABLE SendBackInfo ADD CONSTRAINT fk_stbi_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);

ALTER TABLE BookComments ADD CONSTRAINT fk_bc_us FOREIGN KEY (user_ID) REFERENCES Users (user_ID);

ALTER TABLE BookComments ADD CONSTRAINT fk_bc_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);

ALTER TABLE lostBooks ADD CONSTRAINT fk_lb_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);

ALTER TABLE lostBooks ADD CONSTRAINT fk_lb_us FOREIGN KEY (user_ID) REFERENCES Users (user_ID);

ALTER TABLE BooksAddInfo ADD CONSTRAINT fk_bka_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);

ALTER TABLE BooksAddInfo ADD CONSTRAINT fk_bka_ad FOREIGN KEY (ad_ID) REFERENCES admins (ad_ID);

ALTER TABLE BooksDownInfo ADD CONSTRAINT fk_bkd_ad FOREIGN KEY (ad_ID) REFERENCES admins (ad_ID);

ALTER TABLE BooksDownInfo ADD CONSTRAINT fk_bkd_bk FOREIGN KEY (bk_ID) REFERENCES Books (bk_ID);



