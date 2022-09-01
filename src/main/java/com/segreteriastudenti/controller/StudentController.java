package com.segreteriastudenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.segreteriastudenti.model.DegreeCourse;
import com.segreteriastudenti.model.Student;
import com.segreteriastudenti.util.DummyDb;


@Controller
@RequestMapping("/universitaroma/student")
public class StudentController {
//	ApplicationContext ctx=new AnnotationConfigApplicationContext(StudentConfig.class);
//	DummyDb db=(DummyDb)ctx.getBean("getDummydb");
	
	@Autowired
	private ApplicationContext ctx;
	
	private DummyDb getDummyDb() {
		return ctx.getBean(DummyDb.class);
	}
	
	@GetMapping("/list")
	public String getStudentList(ModelMap m) {
		List<Student> lista=getDummyDb().getAllStudent();
		m.addAttribute("listaStudenti", lista);
		return "studentList";
	}
	
	@GetMapping("/studentform")
	public String showStudentForm(ModelMap model) {
		System.out.println("db:"+ getDummyDb());
		Student s = new Student ();
		List<DegreeCourse> list=getDummyDb().getAllDegreeCourse();
		model.addAttribute("student",s);
		model.addAttribute("coursesList",list);
//		ModelAndView mv= new ModelAndView("formNewStudent","student", new Student());
//		mv.addObject("coursesList",list);
		return "formNewStudent";
	}
	@PostMapping(value="/insertStudent")
	public String addStudent(Student s, BindingResult result, Model m) {
		getDummyDb().addNewStudent(s);
		List<Student> lista=getDummyDb().getAllStudent();
		m.addAttribute("listaStudenti", lista);
		return "studentList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id, Model m) {
		getDummyDb().deleteStudent(id);
		List<Student> lista=getDummyDb().getAllStudent();
		m.addAttribute("listaStudenti", lista);
		return "studentList";
		
	}
	@GetMapping("/updatestudentform/{id}")
	public String showUpdateStudentForm(@PathVariable String id, Model model) {
		Student s = getDummyDb().getStudenteByStudentId(id);
		model.addAttribute("student",s);
		return "updateStudent";
	}
	@PostMapping("/update/{id}")
	public String updateStudent(Student s, Model m) {
		getDummyDb().updateStudent(s);
		List<Student> lista=getDummyDb().getAllStudent();
		m.addAttribute("listaStudenti", lista);
		return "studentList";
		
	}
	

}
