package com.app.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

	private Integer errorCode;
	private String errorDesc;
	private Date errorDate;
}
