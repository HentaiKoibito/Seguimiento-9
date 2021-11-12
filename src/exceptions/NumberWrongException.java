package exceptions;

@SuppressWarnings("serial")
public class NumberWrongException extends Exception{
	
	public NumberWrongException() {
		super("Number of the document does not match with the date");
	}
}