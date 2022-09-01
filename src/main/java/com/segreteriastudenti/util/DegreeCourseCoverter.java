package com.segreteriastudenti.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.segreteriastudenti.model.DegreeCourse;

@Component
public class DegreeCourseCoverter implements Converter<String, DegreeCourse> {
	@Autowired
	private ApplicationContext ctx;

	@Override
	public DegreeCourse convert(String source) {
		DummyDb db = ctx.getBean(DummyDb.class);
		return db.getCourseById(source);
	}

}
