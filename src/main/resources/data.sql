INSERT INTO USER_TABLE (ID, USER_LOGIN, PASSWORD, EMAIL, FULLNAME, SECOND_NAME, COUNTRY, CITY, POINTS, CREATED, ENABLED)
VALUES (user_seq.nextval, 'Kanekx', 'fullname1','123@123.com','seconaname1','name','country1','city1',10, '2015-12-17', TRUE );
INSERT INTO QUEST (ID, FULLNAME, CITY, STATUS, USER_ID)
VALUES (quest_seq.nextval, 'Adam','Kowalski','COMPLETED',1);

