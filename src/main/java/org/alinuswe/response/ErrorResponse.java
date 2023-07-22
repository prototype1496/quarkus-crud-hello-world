package org.alinuswe.response;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class ErrorResponse {

	private Boolean success;
	
	private int statusCode;
	// General error message about nature of error
	private String message;

	private Object data;
	
}
