package com.laxmanbalaji.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laxmanbalaji.mvc.interfaces.CourseAndStudent;
import com.laxmanbalaji.mvc.repo.CourseRepo;
import com.laxmanbalaji.mvc.repo.EarnRepo;
import com.laxmanbalaji.mvc.repo.StudentRepo;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CourseRepo courseRepo;

	@RequestMapping("")
	public String home() {
		System.out.println("Student Home page is requested...");
		return "studentInfo";
	}

	@RequestMapping("/findAllStudents")
	public String getstudents(Model m) {
		System.out.println("Requested all students...");

		m.addAttribute("students", studentRepo.getAllStudents());
		return "showStudents";
	}

	@RequestMapping("/findStudentById")
	public String getstudentById(@RequestParam int studentId, Model m) {
		System.out.println("Requested student by ID...");
		m.addAttribute("hide", 1);
		m.addAttribute("student", studentRepo.getStudentById(studentId));
		return "studentInfo";
	}

	@RequestMapping("/findCoursesByStudent")
	public String getCoursesByStudentId(@RequestParam int studentId, @RequestParam String studentName, Model m) {
		System.out.println(studentId);
		System.out.println("Requested courses by  Student ID...");

		List<CourseAndStudent> courses = studentRepo.getCourses(studentId);

		m.addAttribute("hide", 2);
		m.addAttribute("studentName", studentName);
		m.addAttribute("studentId", studentId);
		m.addAttribute("courses", courses);
		return "studentInfo";
	}

	@RequestMapping("/findAllStudents/Tuition")
	public String getstudentsTuition(Model m) {
		System.out.println("Requested all students...");

		m.addAttribute("students", studentRepo.getTuition());
		return "showStudentsTotal";
	}

	@RequestMapping("/addStudentForm")
	public String addStudentForm() {
		System.out.println("Student Form is requested...");
		return "addStudent";
	}

	@RequestMapping("/register")
	public String addStudentRegister(Model m) {
		System.out.println("Student Form is requested...");
		m.addAttribute("courses", courseRepo.getAllCourses());
		return "studentCourseRegister";
	}

	@RequestMapping("/register/submit")
	public String updateStudentCourse(@RequestParam String[] coursesChosen, @RequestParam String studentName,
			@RequestParam int studentId, Model m) {
		System.out.println("Student Form is requested...");
		m.addAttribute("courses", courseRepo.getAllCourses());
		try {
			List<CourseAndStudent> courses = studentRepo.getCourses(studentId);
			for (int i = 0; i < courses.size(); i++) {
				studentRepo.unregisterCourse(studentId, courses.get(i).getCourseNumber());
			}

			for (int i = 0; i < coursesChosen.length; i++) {
				studentRepo.registerCourse(studentId, coursesChosen[i]);
			}
			int tuition = studentRepo.calculateTuition(studentId);
			System.out.println("tuition " + tuition);

			studentRepo.updateTuition(studentId, tuition, "True");
			m.addAttribute("submission", 2);
			return "studentCourseRegister";
		} catch (Exception e) {
			m.addAttribute("submission", 1);
			return "studentCourseRegister";
		}

	}

	@RequestMapping("/addStudentForm/submit")
	public String addStudent(@RequestParam String gender, @RequestParam String studentName, @RequestParam int studentId,
			Model m) {
		System.out.println("Student Form is requested...");
		try {
			studentRepo.insertStudent(studentId, studentName, gender);
		} catch (Exception e) {
			m.addAttribute("submission", 1);
			return "addStudent";
		}
		m.addAttribute("submission", 2);
		return "addStudent";
	}

	@RequestMapping("/updateStudentForm")
	public String updateStudentForm() {
		System.out.println("Student Form is requested...");
		return "updateStudentInfo";
	}

	@RequestMapping("/updateStudentForm/submit")
	public String updateStudent(@RequestParam String gender, @RequestParam String studentName,
			@RequestParam int studentId, Model m) {
		System.out.println("Student Form is requested...");
		try {
			studentRepo.updateStudent(studentId, studentName, gender);
		} catch (Exception e) {
			m.addAttribute("submission", 1);
			return "updateStudentInfo";
		}
		m.addAttribute("submission", 2);
		return "updateStudentInfo";
	}

	/*
	 * @RequestMapping("/findstudentBySalary") public String
	 * getstudentBySalary(@RequestParam int salaryStart, @RequestParam int
	 * salaryEnd, Model m) { System.out.println("Requested student by Salary...");
	 * m.addAttribute("hide", 1); m.addAttribute("salaryStart", salaryStart);
	 * m.addAttribute("salaryEnd", salaryEnd); m.addAttribute("students",
	 * studentRepo.getstudentBySalary(salaryStart, salaryEnd)); return
	 * "showstudents"; }
	 */
}
