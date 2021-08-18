
create table message(
	mid int primary key,
	title varchar(30),
	 
	content varchar(100)
	
	
);

create table member(
 	id varchar(30) primary key,
 	password varchar(30),
 	name varchar(30),
 	role varchar(30)
);

insert into message(mid,title,content) values(1,'me','whatsup'); 
select * from message;
select * from MEMBER;
drop table member;
drop table message;

CREATE SEQUENCE message_SEQ START WITH 1 INCREMENT BY 1;
