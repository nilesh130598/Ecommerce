package app.ecommerce.category.exception;

public class CategoryNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	final String message;
	public CategoryNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
