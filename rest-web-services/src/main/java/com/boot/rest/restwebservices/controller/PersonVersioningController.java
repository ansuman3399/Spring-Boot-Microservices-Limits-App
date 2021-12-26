package com.boot.rest.restwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.restwebservices.model.Name;
import com.boot.rest.restwebservices.model.PersonV1;
import com.boot.rest.restwebservices.model.PersonV2;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Ansuman Mohanty");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Ansuman", "Mohanty"));
	}
}
