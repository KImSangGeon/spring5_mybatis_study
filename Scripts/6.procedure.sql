--  procedure
select  *
  from tutors t left join courses c 
  on t.tutor_id  = c.tutor_id ;
  
--  교수가 개설한 교과목 수를 구하시오.
 select  t.name as tutor, count(c.name) as total 
 	 from tutors t left join courses c 
 	 on t.tutor_id  = c.tutor_id 
 where t.tutor_id = 3;
 
 select 
 	from tutors t left join courses c 
 	on t.tutor_id = c.tutor_id 
 group by t.tutor_id;
 
DROP PROCEDURE IF EXISTS course_total;

DROP PROCEDURE IF EXISTS course_total;


DROP PROCEDURE IF EXISTS course_total_group;

DELIMITER $$ 
$$
CREATE PROCEDURE mybatis_study.course_total_group()
begin
   select t.name as tutor, ifnull(count(c.name),0) as total
      from tutors t left join courses c 
      on t.tutor_id = c.tutor_id 
      group by t.tutor_id;
END$$ 
DELIMITER ;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total(in t_id int)
begin
	 select  t.name as tutor, count(c.name) as total 
 		 from tutors t left join courses c 
 		 on t.tutor_id  = c.tutor_id 
 	where t.tutor_id = t_id;
END$$
DELIMITER ;

-- 호출은 call
call course_total(1); 


DROP PROCEDURE IF EXISTS course_total_group;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total_group()
begin
	 select   t.name as tutor, count(c.name) as total 
 		 from tutors t left join courses c 
 		 on t.tutor_id  = c.tutor_id 
 	group by t.tutor_id;
END$$
DELIMITER ;

-- 호출은 call
call course_total(1); 


DELIMITER $$
 $$
 CREATE PROCEDURE mybatis_study.course_total_group()
begin
	  select   t.name as tutor, count(c.name) as total 
 		 from tutors t left join courses c 
 		 on t.tutor_id  = c.tutor_id 
 	 	group by t.tutor_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS mybatis_study.course_total_group;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total_group()
BEGIN
	  select t.name as tutor, ifnull(count(c.name),0) as total
      from tutors t left join courses c 
      on t.tutor_id = c.tutor_id 
      group by t.tutor_id;
     
	END$$
DELIMITER ;

call course_total_group(); 

