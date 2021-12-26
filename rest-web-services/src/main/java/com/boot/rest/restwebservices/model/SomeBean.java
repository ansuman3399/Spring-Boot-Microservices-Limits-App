package com.boot.rest.restwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;

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
//@JsonIgnoreProperties(value= {"field1","field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String field1;
	private String field2;
//	@JsonIgnore
	private String field3;
}
