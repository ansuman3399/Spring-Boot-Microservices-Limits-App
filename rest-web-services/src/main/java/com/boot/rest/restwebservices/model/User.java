package com.boot.rest.restwebservices.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

	private Integer id;
	@Size(min=2 , message = "Name should be minimum 2 characters long!")
	@NotNull(message = "User name should not be null")
	private String name;
	@Past
	private Date birthDate;

}
