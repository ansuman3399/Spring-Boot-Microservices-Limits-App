package com.boot.rest.restwebservices.exception;

import java.util.Date;

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
public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;

}
