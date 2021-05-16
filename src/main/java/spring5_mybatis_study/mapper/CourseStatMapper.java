package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.CourseStat;

public interface CourseStatMapper {

//	Map<String, Object> getCourseCountByTutor(Map<String, Object> param);
//	Map<String, Object> getCourseCountByTutor2(Map<String, Object> param);
	CourseStat getCourseCountByTutor(int param);
	}
