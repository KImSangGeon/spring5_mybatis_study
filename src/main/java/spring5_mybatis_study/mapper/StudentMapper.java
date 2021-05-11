package spring5_mybatis_study.mapper;


import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper {
	
		Student selcetStudentById(Student student);
		
		//핸들러없이 만들기
		Student selectStudetnByIdWithResultMap(Student student);
		
		List<Student> selectStudentByAll();
		
		int insertStudent(Student student);
		int deleteStudent(int id);
		int updateStudent(Student student);
		List<Map<String, Object>> selectStudentByAllForHashMap();
		//  내포된 결과매핑(ResultMap)을 사용한 일대일 매핑
		Student selectStudentByIdAssociation(Student student);
}
