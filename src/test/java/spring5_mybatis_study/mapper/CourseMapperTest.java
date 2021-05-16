package spring5_mybatis_study.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {
		
	private static final Log log  =LogFactory.getLog(CourseMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private CourseMapper mapper;

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		
		List<Course	> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	@Test
	public void test02SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%Java%");
		
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		
	}
	
	@Test
	public void test03SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime());
	
		List<Course> list = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}
	@Test
	public void test04SelectCaseCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		List<Course> list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("name", "%Java%");
		
		list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}
	
	@Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectWhereCourse(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.put("tutorId", 1);
		list = mapper.selectWhereCourse(map);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.put("name", "%Java%");
		list = mapper.selectWhereCourse(map);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.clear();
		map.put("endDate", new Date());
		list = mapper.selectWhereCourse(map);
		list.stream().forEach(System.out::println);		
		
	}
	@Test
	public void test06SelectTrimCourses() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.clear();
		map.put("name", "%Java%");
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		map.clear();
		map.put("tutorId", 1);
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}
	@Test
	public void test07SelectCoursesForeachByTutoes() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);
		
		List<Course> list = mapper.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void test08InsertCourses() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		List<Course> tutors = new ArrayList<Course>();
		tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(5, "Spring", "Support develope", new Date(), new Date(), 3));
		tutors.add(new Course(6, "gradle", "support building", new Date(), new Date(), 4));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutors", tutors);
		
		int res = mapper.insertCourses(map);
		Assert.assertEquals(3, res);
	}
	@Test
	public void test09DeleteCourse() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		List<Integer> courseIds = new ArrayList<Integer>();
		courseIds.add(4);
		courseIds.add(5);
		courseIds.add(6);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseIds", courseIds);
		

		int res = mapper.deleteCourses(map);
		Assert.assertEquals(3, res);
	}
	@Test
	public void test10UpdateSetStudent() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	
		
		Student student  = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("010-5533-2252"));
		student.setDob(new Date());
		
		int res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
		System.out.println();
		student.setName("Timothy");
		student.setPhone(new PhoneNumber("010-5555-2222"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		
		res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
	}
	
	@Test 
	public void test11InsertCourseAndDeleteCourse() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	

		Course course = new Course(7, "oracle", "database", new Date(), new Date(), 4);
		int res = mapper.insertCourse(course);
		
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("tutorId", 4);
		
		List<Course> list = mapper.selectCoursesByCondition(map);
		list.stream().forEach(System.out::println);
		
		res += mapper.deleteCourse(course.getCourseId());
		Assert.assertEquals(2, res);
		
		
		
	}
	
	

}
