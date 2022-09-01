package com.segreteriastudenti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.segreteriastudenti.util.DummyDb;

@Configuration
public class StudentConfig {
	DummyDb dummyDb = new DummyDb();

	@Bean
	@Scope("singleton")
	public DummyDb getDummydb() {
		return dummyDb;
	}
}
