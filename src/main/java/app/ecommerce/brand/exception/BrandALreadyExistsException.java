package app.ecommerce.brand.exception;

public class BrandALreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	final String message;
	public BrandALreadyExistsException(String message) {
		super();
		this.message = message;
	}
	
}
