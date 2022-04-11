package app.ecommerce.brand.exception;

public class BrandNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	 final String message;
	public BrandNotFoundException(String message) {
		super();
		this.message = message;
	}

}
