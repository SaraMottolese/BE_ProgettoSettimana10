package com.segreteriastudenti.util;

import java.util.ArrayList;
import java.util.List;

import com.segreteriastudenti.model.DegreeCourse;
import com.segreteriastudenti.model.Student;

import lombok.Getter;


@Getter
public class DummyDb {

	List<DegreeCourse> courses;
	List<Student> students = new ArrayList<>();

	/**************** metodi per il corso di laurea ******************/

	public List<DegreeCourse> getAllDegreeCourse() {
		return courses;
	}

	public String addNewDegreeCourse(DegreeCourse dc) {
		String mex = "Corso inserito correttamente";
		if (courses == null) {
			courses = new ArrayList<>();
		}
		if (courses.contains(dc))
			mex = "Corso gia' esistente nel database";
		else
			courses.add(dc);
		return mex;
	}

	public String updateDegreeCourse(DegreeCourse dc) {
		String mex = "Corso non trovato";
		if (courses != null) {
			for (DegreeCourse course : courses) {
				if (course.getId().equals(dc.getId())) {
					course.setDegreeAddress(dc.getDegreeAddress());
					course.setDegreeName(dc.getDegreeName());
					course.setNumberOfExams(dc.getNumberOfExams());
					mex = "corso aggiornato con successo";
				}
			}
		}
		return mex;
	}

	public String deleteDegreeCourse(String id) {
		String mex = "Corso non trovato";
		if (courses != null) {
			DegreeCourse d = new DegreeCourse();
			for (DegreeCourse course : courses) {
				if (course.getId().equals(id)) {
					d = course;
					mex = "corso aggiornato con successo";
				}
			}
			courses.remove(d);
		}
		return mex;
	}

	public DegreeCourse getCourseById(String id) {
		DegreeCourse d = new DegreeCourse();
		if (courses != null) {
			for (DegreeCourse course : courses) {
				if (course.getId().equals(id))
					d = course;
			}
		}
		return d;
	}

	/**************** metodi per lo studente ******************/

	public List<Student> getAllStudent() {
		return students;
	}

	public String addNewStudent(Student s) {
		String mex = "studente inserito correttamente";
		if (students.contains(s))
			mex = "studente gia' esistente nel database";
		else
			students.add(s);
		return mex;
	}

	public String updateStudent(Student s) {
		String mex = "studente non trovato";
		for (Student student : students) {
			if (student.getStudentId().equals(s.getStudentId())) {
				student.setName(s.getName());
				student.setAddress(s.getAddress());
				student.setCityOfResidence(s.getCityOfResidence());
				student.setDateOfBirth(s.getDateOfBirth());
				student.setDegreeCourse(s.getDegreeCourse());
				student.setLastname(s.getLastname());
				mex = "studente aggiornato con successo";
			}
		}
		return mex;
	}

	public String deleteStudent(String studentId) {
		String mex = "studente non trovato";
		Student s = new Student();
		for (Student student : students) {
			if (student.getStudentId().equals(studentId)) {
				s = student;
				mex = "studente eliminato con successo";
			}
		}
		students.remove(s);
		return mex;
	}

	public Student getStudenteByStudentId(String id) {
		Student s = new Student();
		for (Student student : students) {
			if (student.getStudentId().equals(id))
				s = student;
		}
		return s;
	}

}
