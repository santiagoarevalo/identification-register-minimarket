package exceptions;

@SuppressWarnings("serial")
public class UnderAgeException extends Exception {
	
	public UnderAgeException() {
		super("The document type belongs to a non-adult person");
	}
}
