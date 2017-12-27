package adServer.model;

import java.util.ArrayList;
import java.util.List;


public class ValidationException extends Exception {


	private static final long serialVersionUID = -4306281151724780145L;
	
	List<ValidationExceptionMessage> messages = new ArrayList<ValidationExceptionMessage>();
	
	public ValidationException(String message) {
		super(message);
	}
	
	public void addValidationExceptionMessage(ValidationExceptionMessage validationMessage) {
		messages.add(validationMessage);
	}
	
	public void addValidationExceptionMessages(List<ValidationExceptionMessage> validationMessages) {
		messages.addAll(validationMessages);
	}	
	
	public static ValidationException create(List<ValidationExceptionMessage> validationMessages) {
		ValidationException ve  = new ValidationException("");
		ve.addValidationExceptionMessages(validationMessages);
		return ve;
	}
	
	public List<ValidationExceptionMessage> getMessages() {
		return messages;
	}
	
	public int getMessagesSize() {
		return messages.size();
	}


}
