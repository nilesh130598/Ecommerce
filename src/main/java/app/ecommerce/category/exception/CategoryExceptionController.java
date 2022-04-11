package app.ecommerce.category.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionController {
@ExceptionHandler(value = EnterProperFieldsException.class)
public ResponseEntity<Object> exception(EnterProperFieldsException exception){
	EnterProperFieldsException ep = exception;
	return new ResponseEntity<>(ep.message, HttpStatus.NOT_ACCEPTABLE);
}

@ExceptionHandler(value = CategoryNotFoundException.class)
public ResponseEntity<Object> exception(CategoryNotFoundException exception){
	CategoryNotFoundException ep = exception;
	return new ResponseEntity<>(ep.message, HttpStatus.NOT_FOUND);
}
}
