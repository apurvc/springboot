package exception;

public class QuoteNotFoundException extends RuntimeException{

	public QuoteNotFoundException() {
		super();
	}
	
    public QuoteNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public QuoteNotFoundException(final String message) {
        super(message);
    }

    public QuoteNotFoundException(final Throwable cause) {
        super(cause);
    }
	
	
}
