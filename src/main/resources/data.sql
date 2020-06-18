INSERT INTO USER_TABLE (ID, USER_LOGIN, FULLNAME, SECOND_NAME, COUNTRY, CITY, POINTS)
VALUES (user_seq.nextval, 'Kanekx', 'fullname1','seconaname1','country1','city1',10);
INSERT INTO QUEST (ID, FULLNAME, CITY, STATUS, USER_ID)
VALUES (quest_seq.nextval, 'Adam','Kowalski','COMPLETED',1);

