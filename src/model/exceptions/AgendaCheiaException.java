package model.exceptions;

public class AgendaCheiaException extends Exception {
	
	@Override
	public String getMessage() {
		return "The Schedule is already full";
	}

}
