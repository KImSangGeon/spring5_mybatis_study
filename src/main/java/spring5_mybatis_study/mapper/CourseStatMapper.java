package spring5_mybatis_study.mapper;

import java.util.List;

import spring5_mybatis_study.dto.CourseStat;

public interface CourseStatMapper {

//	Map<String, Object> getCourseCountByTutor(Map<String, Object> param);
//	Map<String, Object> getCourseCountByTutor2(Map<String, Object> param);
	
	/* 교수별 과목 수 */
	CourseStat getCourseCountByTutor(int param);
	List<CourseStat> getCourseCount();
	
	}
