package com.laxmanbalaji.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laxmanbalaji.mvc.repo.CourseRepo;
import com.laxmanbalaji.mvc.repo.EarnRepo;
import com.laxmanbalaji.mvc.repo.CourseRepo;

@Controller
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseRepo courseRepo;

	@RequestMapping("")
	public String home() {
		System.out.println("Course Home page is requested...");
		return "courseInfo";
	}

	@RequestMapping("/findAllCourses")
	public String getcourses(Model m) {
		System.out.println("Requested all courses...");

		m.addAttribute("courses", courseRepo.getAllCourses());
		return "showCourses";
	}

	@RequestMapping("/findCourseByNumber")
	public String getcourseById(@RequestParam String courseNumber, Model m) {
		System.out.println("Requested course by ID...");
		m.addAttribute("hide", 1);
		m.addAttribute("course", courseRepo.getCourseByNumber(courseNumber));
		return "courseInfo";
	}

	@RequestMapping("/findStudentsByCourseNumber")
	public String getStudentsByCourseNumber(@RequestParam String courseNumber, Model m) {
		System.out.println("Requested student by Course Number...");
		m.addAttribute("hide", 2);
		m.addAttribute("courseNumber", courseNumber);
		m.addAttribute("students", courseRepo.getStudents(courseNumber));
		return "courseInfo";
	}

	@RequestMapping("/removeCourse")
	public String removeCourse(@RequestParam String courseNumber, Model m) {
		System.out.println("Remove course by ID...");
		m.addAttribute("hide", 0);
		courseRepo.removeCourse(courseNumber);
		return "courseInfo";
	}

	@RequestMapping("/addCourseForm")
	public String addCourseForm() {
		System.out.println("Course Form is requested...");
		return "addCourse";
	}

	@RequestMapping("/addCourseForm/submit")
	public String addCourse(@RequestParam String courseName, @RequestParam int courseFee,
			@RequestParam String courseNumber, Model m) {
		System.out.println("Course Form is submitted...");
		try {
			courseRepo.insertCourse(courseNumber, courseName, courseFee);
			;
		} catch (Exception e) {
			m.addAttribute("submission", 1);
			return "addCourse";
		}
		m.addAttribute("submission", 2);
		return "addCourse";
	}

}
