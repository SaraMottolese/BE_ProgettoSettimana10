package com.segreteriastudenti.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String studentId;
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String name;
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String lastname;
	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message = "Campo obbligatorio!")
	private LocalDate dateOfBirth;
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String address;
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String cityOfResidence;
	private DegreeCourse degreeCourse;
	@NotBlank
	@NotEmpty(message = "Campo obbligatorio!")
	private String email;

}
