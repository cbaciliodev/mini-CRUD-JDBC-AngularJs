
create table user_registration(user_id integer primary key autoincrement,
							   user_name varchar2(20),
							   user_contact number(10),
							   address varchar2(50),
							   gender varchar2(6),
							   country varchar2(10))

							   drop table user_registration

select * from user_registration
delete from user_registration
drop table user_registration