package adServer.model;

import java.io.Serializable;

public class ValidationExceptionMessage implements Serializable{
	


	private static final long serialVersionUID = 209703329472423028L;
	
	private String message;
	private String fieldName;
	private String errorCode;
	
	public ValidationExceptionMessage() {
		super();
	}

	public ValidationExceptionMessage(String sMessage) {
		super();
		message = sMessage;
	}		
	
	public ValidationExceptionMessage(String sMessage, String sFieldName, String sErrorCode) {
		super();
		message = sMessage;
		fieldName = sFieldName;
		errorCode = sErrorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	



}
