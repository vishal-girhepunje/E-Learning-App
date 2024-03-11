package com.GrowSkill.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
	private Date timeStamp;
	
	private String message;
	
	private int Status;
	
	private String error;
	
	private String path;
	
	private String stackTrace;

}
