package com.laxmanbalaji.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseName=" + courseName + ", courseFee=" + courseFee + "]";
	}

	@Id
	private String courseNumber;

	private String courseName;

	private String courseFee;

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}

	/*
	 * @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY) private Set<Staff>
	 * staffs = new HashSet<>();
	 * 
	 * @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY) private
	 * Set<Student> students = new HashSet<>();
	 */

}
