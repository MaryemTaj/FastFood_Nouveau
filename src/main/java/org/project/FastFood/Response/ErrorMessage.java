package org.project.FastFood.Response;

public enum ErrorMessage {
	
	MISSING_REQUIRED_FIELD("Missing required field."),
    RECORD_ALREADY_EXISTS("Record already exists."),
    INTERNAL_SERVER_ERROR("Internal server error."),
    NO_RECORD_FOUND("Record with provided id is not found.");
	
	 private String errorMessage;

	private ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	 
	 
}