
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

drop table member;