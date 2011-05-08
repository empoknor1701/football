package exception;

public class IORuntimeException extends RuntimeException {
	public IORuntimeException() {
		super();
	}

	public IORuntimeException(String message) {
		super(message);
	}

	public IORuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IORuntimeException(Throwable cause) {
		super(cause);
	}
}
