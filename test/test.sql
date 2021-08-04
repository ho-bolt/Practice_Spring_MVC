
create table message(
	mid int primary key,
	writer varchar(30),
	content varchar(100)
	
	
);

create table member(
 	id varchar(30) primary key,
 	password varchar(30),
 	name varchar(30),
 	role varchar(30)
);

insert into message(mid,writer,content) values(1,'me','whatsup'); 
select * from message;
select * from MEMBER;네 안들어왔어요
drop table member;