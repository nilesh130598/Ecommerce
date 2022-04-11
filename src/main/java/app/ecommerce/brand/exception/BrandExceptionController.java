package app.ecommerce.brand.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BrandExceptionController {

	@ExceptionHandler(value = BrandNotFoundException.class)
	public ResponseEntity<Object> exception(BrandNotFoundException exception){
		BrandNotFoundException ep = exception;
		return new ResponseEntity<>(ep.message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BrandALreadyExistsException.class)
	public ResponseEntity<Object> exception(BrandALreadyExistsException exception){
		BrandALreadyExistsException ep = exception;
		return new ResponseEntity<>(ep.message, HttpStatus.CONFLICT);
	}
}
