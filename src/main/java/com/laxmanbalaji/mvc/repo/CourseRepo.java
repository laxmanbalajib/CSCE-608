package com.laxmanbalaji.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laxmanbalaji.mvc.interfaces.CourseAndStudent;
import com.laxmanbalaji.mvc.model.Course;
import com.laxmanbalaji.mvc.model.Student;

public interface CourseRepo extends CrudRepository<Course, String> {

	@Query(value = "SELECT * FROM Course", nativeQuery = true)
	List<Course> getAllCourses();

	@Query(value = "SELECT * FROM Course WHERE courseNumber = :courseNumber", nativeQuery = true)
	Course getCourseByNumber(String courseNumber);

	@Query(value = "SELECT * FROM Student,\n"
			+ "(SELECT * FROM Course NATURAL JOIN Attend WHERE courseNumber=:courseNumber) as b\n"
			+ "WHERE Student.id = b.studentId", nativeQuery = true)
	List<CourseAndStudent> getStudents(String courseNumber);

	@Modifying
	@Query(value = "INSERT INTO Course(courseNumber, courseName, courseFee) VALUES(:courseNumber, :courseName, :courseFee)", nativeQuery = true)
	@Transactional
	void insertCourse(int courseNumber, String courseName, int courseFee);
	

}
