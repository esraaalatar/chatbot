CREATE TABLE IF NOT EXISTS USERS (
 userid INT PRIMARY KEY auto_increment,
 username VARCHAR(20),
 salt VARCHAR,
 password VARCHAR,
 firstname VARCHAR(20),
 lastname VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS MESSAGES (
 messageid INT PRIMARY KEY auto_increment,
 username VARCHAR ,
 messagetext VARCHAR NOT NULL
);
CREATE TABLE IF NOT EXISTS REPLY  (
                                       replyid INT PRIMARY KEY auto_increment,
                                       reply_msg VARCHAR NOT NULL
);
CREATE TABLE IF NOT EXISTS INTENT  (
                                       intentid INT PRIMARY KEY auto_increment,
                                        intent_name VARCHAR NOT NULL,
                                       description VARCHAR ,
                                       replyId INT NOT NULL
    );
CREATE TABLE IF NOT EXISTS INTENT_MESSAGE  (
                                       id INT PRIMARY KEY auto_increment,
                                       msgId INT NOT NULL,
                                       intentId INT NOT NULL,
                                       confidance DOUBLE
);
insert into reply (replyid,reply_msg) values (1,'Hello I am here to help you!');
insert into reply (replyid,reply_msg) values (4,'Oh! sorry i am not understand');
insert into reply (replyid,reply_msg) values (3,'Yes, sure!');
insert into reply (replyid,reply_msg) values (2,'GoodBye!');

insert into MESSAGES (messageid,messagetext) values (1,'Hello');
insert into MESSAGES (messageid,messagetext) values (2,'Bye');
insert into MESSAGES (messageid,messagetext) values (3,'sorry');
insert into MESSAGES (messageid,messagetext) values (4,'ok');

insert into INTENT (intentid,replyId,intent_name) values (4,1,'hello');
insert into INTENT (intentid,replyId,intent_name) values (1,2,'sorry');
insert into INTENT (intentid,replyId,intent_name) values (3,3,'yes');
insert into INTENT (intentid,replyId,intent_name) values (2,4,'bye');

insert into INTENT_MESSAGE (id,intentid,msgId) values (1,4,1);
insert into INTENT_MESSAGE (id,intentid,msgId) values (2,1,2);
insert into INTENT_MESSAGE (id,intentid,msgId) values (3,2,4);
insert into INTENT_MESSAGE (id,intentid,msgId) values (4,3,3);

