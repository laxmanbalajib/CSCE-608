package com.laxmanbalaji.mvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.laxmanbalaji.mvc.interfaces.CourseAndStudent;
import com.laxmanbalaji.mvc.interfaces.StudentAndTuition;
import com.laxmanbalaji.mvc.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	@Query(value = "SELECT * FROM Student", nativeQuery = true)
	List<Student> getAllStudents();

	@Query(value = "SELECT * FROM Student WHERE id = :studentId", nativeQuery = true)
	Student getStudentById(int studentId);

	@Query(value = "SELECT * FROM Staff,Earn WHERE Earn.salary >= :salaryStart AND Earn.salary <= :salaryEnd  AND Earn.staffId = Staff.id", nativeQuery = true)
	List<Student> getStaffBySalary(int salaryStart, int salaryEnd);

	@Query(value = "SELECT id, name, tuition, paid FROM Student,TuitionFee WHERE Student.id = TuitionFee.studentId", nativeQuery = true)
	List<StudentAndTuition> getTuition();

	@Modifying
	@Query(value = "INSERT INTO Student(id, name, gender) VALUES(:studentId, :studentName, :gender)", nativeQuery = true)
	@Transactional
	void insertStudent(int studentId, String studentName, String gender);

	@Query(value = "SELECT * FROM Student, (SELECT * FROM Course NATURAL JOIN Attend) as B WHERE Student.id = B.studentId AND Student.id = :studentId", nativeQuery = true)
	List<CourseAndStudent> getCourses(int studentId);

	@Modifying
	@Query(value = "UPDATE Student SET gender = :gender, name = :studentName WHERE id = :studentId", nativeQuery = true)
	@Transactional
	void updateStudent(int studentId, String studentName, String gender);

	@Modifying
	@Query(value = "INSERT INTO Attend(courseNumber, studentId) VALUES(:courseNumber, :studentId)", nativeQuery = true)
	@Transactional
	void registerCourse(int studentId, String courseNumber);
	
	@Modifying
	@Query(value = "DELETE FROM Attend WHERE studentId = :studentId AND courseNumber = :courseNumber", nativeQuery = true)
	@Transactional
	void unregisterCourse(int studentId, String courseNumber);
	
	@Query(value = "SELECT SUM(courseFee) FROM Course, Attend  WHERE Attend.courseNumber = Course.courseNumber AND Attend.studentId = :studentId", nativeQuery = true)
	int calculateTuition(int studentId);
	
	@Modifying
	@Query(value = "UPDATE TuitionFee SET tuition = :tuition,paid = :paid WHERE studentId = :studentId", nativeQuery = true)
	@Transactional
	void updateTuition(int studentId, int tuition, String paid);
}
