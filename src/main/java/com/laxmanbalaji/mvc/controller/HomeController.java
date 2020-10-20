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
import com.laxmanbalaji.mvc.repo.StaffRepo;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	StaffRepo staffRepo;

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	EarnRepo earnRepo;

	@RequestMapping("")
	public String home() {
		System.out.println("Home page is requested...");
		return "index";
	}

	@RequestMapping("getStaffs")
	public String getStaffs(Model m) {
		System.out.println("Requested all staffs...");

		m.addAttribute("staffs", staffRepo.findAll());
		return "showStaffs";
	}

	@RequestMapping("getCourses")
	public String getCourses(Model m) {
		System.out.println("Requested all courses...");

		m.addAttribute("courses", courseRepo.findAll());
		return "showCourses";
	}

	@RequestMapping("addEarning")
	public String addEarning(@RequestParam int staffId, @RequestParam int salary, Model m) {
		System.out.println("Requested all courses...");

		earnRepo.updateEarning(staffId, salary);
		m.addAttribute("staffs", earnRepo.getAllEarnByStaffId(staffId));
		// m.addAttribute("courses", courseRepo.findAll());
		return "showStaffs";
	}

	@GetMapping("getStaffById")
	public String getStaffById(@RequestParam int id, Model m) {
		System.out.println("Requested a staff by Id..");

		m.addAttribute("staffs", earnRepo.getAllEarnByStaffId(id));
		return "showStaffs";
	}

	@GetMapping("getAllCourses")
	public String getCourseByNumber(Model m) {
		System.out.println("Requested all courses...");

		m.addAttribute("courses", courseRepo.getAllCourses());
		return "showCourses";
	}

	@GetMapping("getStaffByCourseNumber")
	public String getStaffByCourseNumber(@RequestParam String courseNumber, Model m) {
		System.out.println("Requested a courses by Course Number...");

		// m.addAttribute("course", sqlRepo.getAll());
		// m.addAttribute("staffs", courseRepo.getOne(courseNumber).getStaffs());
		// m.addAttribute("students", courseRepo.getOne(courseNumber).getStudents());
		return "showCoursesAndStaffs";
	}

	/*
	 * @GetMapping("getAlienByName") public String getAlien(@RequestParam String
	 * name, Model m) {
	 * 
	 * //m.addAttribute("aliens", repo.findByName(name)); //m.addAttribute("aliens",
	 * repo.findByNameOrderByAgeDesc(name)); //m.addAttribute("aliens",
	 * repo.find(name)); m.addAttribute("aliens", repo.findOneByName(name));
	 * 
	 * return "showAliens"; }
	 */
}
