package app.ecommerce.category.exception;

public class EnterProperFieldsException extends RuntimeException{
 private static final long serialVersionUID = 1L;
 final String message;


public EnterProperFieldsException(String message) {
	super();
	this.message = message;
}

 
 
}
