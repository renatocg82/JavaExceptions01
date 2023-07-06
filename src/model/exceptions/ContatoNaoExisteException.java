package model.exceptions;

public class ContatoNaoExisteException extends Exception {
	
	private String contactName;
	
	public ContatoNaoExisteException (String contactName) {
		this.contactName = contactName; 
	}
	
	@Override
	public String getMessage() {
		return "This contact named " + contactName + " does not exist!" + "\n";
		}
}
