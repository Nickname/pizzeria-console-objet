package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {
	
	private static final long serialVersionUID = 1L;
	
	public SavePizzaException() {
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
