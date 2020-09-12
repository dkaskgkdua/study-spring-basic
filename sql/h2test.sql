-- http://h2database.com/html/main.html 사이트에서 h2database 다운
-- jdbc:h2:~/test 입력 후 생성
-- 이후부턴 jdbc:h2:tcp://localhost/~/test 으로 접속

drop table if exists member cascade;

create table member
(
 id bigint generated by default as identity, -- 값이 들어오지 않을 때 자동으로 insert
name varchar(255),
primary key(id)
);

SELECT * FROM MEMBER MEMBER;


insert into member(name) values('spring');