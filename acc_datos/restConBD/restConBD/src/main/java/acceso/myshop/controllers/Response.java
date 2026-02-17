package acceso.myshop.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


public class Response {
	public static final int NO_ERROR = 0;
	public static final int NOT_FOUND = 101;
	public static final String NO_MESSAGE = "";

	private Error error; //da error, tenemos que crear constructores
	public Response(Error error) {
		super();
		this.error = error;
	}

	static class Error {
		private long errorCode;
		private String message;
		public Error(long errorCode, String message) {
			super();
			this.errorCode = errorCode;
			this.message = message;
		}
		
	}

	public static Response noErrorResponse() {
		return new Response(new Error(NO_ERROR, NO_MESSAGE));
	}

	public static Response errorResonse(int errorCode, String errorMessage) {
		return new Response(new Error(errorCode, errorMessage));
	}
}
