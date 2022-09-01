package com.segreteriastudenti.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.segreteriastudenti.model.DegreeCourse;
import com.segreteriastudenti.model.Student;
@Component
public class DummyDbLoader implements CommandLineRunner {

	@Autowired
	private ApplicationContext ctx;
	@Override
	public void run(String... args) throws Exception {
		DummyDb db = ctx.getBean(DummyDb.class);
		loadDb(db);
	}
	private void loadDb(DummyDb db) {
		System.out.println("inizio caricamento");
		DegreeCourse c1= new DegreeCourse("mat1","Informatica","Matematica e Fisica",20);
		DegreeCourse c2= new DegreeCourse("mat2","Fisica","Matematica e Fisica",15);
		DegreeCourse c3= new DegreeCourse("let1","Storia","Lettere e Filosofia",20);
		DegreeCourse c4= new DegreeCourse("lin1","Lingue e culture orientali","Lettere e Filosofia",20);
		Student s1= new Student("ma1","Mario","Rossi",LocalDate.of(2000, 1, 1),"Via Roma","Roma",c1,"mario@rossi.com");
		Student s2= new Student("ma2","Franca","Bianchi",LocalDate.of(1989,12,12),"Via gallia","Roma",c2,"franca@bianchi.com");
		Student s3= new Student("ma3","Marci","Verdi",LocalDate.of(2003,8,13),"Via Appia","Roma",c3,"marco@verdi.com");
		Student s4= new Student("dad","Angela","Gialli",LocalDate.of(2001,7,5),"Via dei cerchi","Roma",c4,"angela@gialli.com");
		Student s5= new Student("rtg","Franco","Franchi",LocalDate.of(2016, 1, 1),"Via Roma","Roma",c4,"franco@franchi.com");
		Student s6= new Student("ma1dfsc45","Giulio","franchi",LocalDate.of(2016, 1, 1),"Via Roma","Roma",c1,"giulio@franchi.com");
		db.addNewDegreeCourse(c4);
		db.addNewDegreeCourse(c3);
		db.addNewDegreeCourse(c2);
		db.addNewDegreeCourse(c1);
		db.addNewStudent(s6);
		db.addNewStudent(s5);
		db.addNewStudent(s4);
		db.addNewStudent(s3);
		db.addNewStudent(s2);
		db.addNewStudent(s1);
		
	}

}
