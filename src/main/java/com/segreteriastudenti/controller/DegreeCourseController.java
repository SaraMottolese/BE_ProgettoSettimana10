package com.segreteriastudenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.segreteriastudenti.config.StudentConfig;
import com.segreteriastudenti.model.DegreeCourse;
import com.segreteriastudenti.util.DummyDb;

@Controller
@RequestMapping("/universitaroma/course")
public class DegreeCourseController {
	
	@Autowired
	private ApplicationContext ctx;
	
	private DummyDb getDummyDb() {
		return ctx.getBean(DummyDb.class);
	}
	
	@GetMapping("/list")
	public String getCourseList(ModelMap m) {
		List<DegreeCourse>list=getDummyDb().getAllDegreeCourse();
		System.out.println("db degree"+getDummyDb());
		m.addAttribute("courseList", list);
		return "degreeList";
	}
	
	@GetMapping("/courseform")
	public String showCourseForm(Model model) {
		DegreeCourse dc = new  DegreeCourse();
		model.addAttribute("course",dc);
		return "formNewDegree";
	}
	
	@PostMapping(value="insertCourse")
	public String addCourse(DegreeCourse d, BindingResult result, Model m) {
		getDummyDb().addNewDegreeCourse(d);
		List<DegreeCourse> list=getDummyDb().getAllDegreeCourse();
		m.addAttribute("courseList", list);
		return "degreeList";
	}
	@GetMapping("/delete/{id}")
	public String deleteCourse(@PathVariable String id, Model m) {
		getDummyDb().deleteDegreeCourse(id);
		List<DegreeCourse> list=getDummyDb().getAllDegreeCourse();
		m.addAttribute("courseList", list);
		return "degreeList";
		
	}
	@GetMapping("/updatecourseform/{id}")
	public String showUpdateCourseForm(@PathVariable String id, Model model) {
		DegreeCourse d = getDummyDb().getCourseById(id);
		model.addAttribute("course",d);
		return "updateCourse";
	}
	@PostMapping("/update/{id}")
	public String updateCourse(DegreeCourse d, Model m) {
		getDummyDb().updateDegreeCourse(d);
		List<DegreeCourse> list=getDummyDb().getAllDegreeCourse();
		m.addAttribute("courseList", list);
		return "degreeList";
		
	}
	

}
