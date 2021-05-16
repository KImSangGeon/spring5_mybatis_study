select * from addresses;
select * from  course_enrollment;
select * from courses;
select * from students;
select * from tutors;
select * from user_pics ;

delete 
from courses  
where course_id = 8;

delete 
from tutors 
where tutor_id =5;

delete 
from tutors 
where tutor_id  =5;

desc user_pics ;
show tables;
select stud_id, name, email, dob, phone 
from students 
where stud_id =1;

select stud_id, name, email, dob
, substring(phone, 1, 3) as f
, substring(phone, 5, 3) as m
, substring(phone, 9, 4) as l
from students s
where stud_id = 1;

select stud_id, name, email, dob, phone from students; 

delete from students  where stud_id =3;

select stud_id, name, email, phone, dob, a.addr_id, street, city, state, zip, country
	from students s  join addresses a  on s.addr_id =a.addr_id 
	where stud_id =1;
	
select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
from tutors t left outer join courses c on t.tutor_id=c.tutor_id
where t.tutor_id= 1;

select t.tutor_id, t.name as tutor_name, email, 
		c.course_id, c.name, description, 
		start_date, end_date
		from tutors t  join courses c 
		on t.tutor_id=c.tutor_id
		where t.tutor_id= 1;
		
	delete 
	from students 
	where stud_id =3;
	delete 
	from user_pics 
	where id =1;
	
select course_id, name, description, start_date, end_date, tutor_id from courses;

select course_id, name, description, start_date, end_date, tutor_id
from courses
where course_id =1;

-- %%기억하기
select course_id, name, description, start_date, end_date, tutor_id
from courses
where name  like '%Java%';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where start_date >= '2013-05-01';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where start_date >= '2013-03-01' and end_date <= '2013-07-01';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where course_id in(1,2);

delete 
from courses 
where course_id in (4, 5, 6);