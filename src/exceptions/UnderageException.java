package exceptions;

@SuppressWarnings("serial")
public class UnderageException extends Exception{
	
	public UnderageException() {
		super("Minors are not allowed");
	}
}
