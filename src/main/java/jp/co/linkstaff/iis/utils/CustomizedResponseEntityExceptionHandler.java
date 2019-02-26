package jp.co.linkstaff.iis.utils;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Roy
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(ServerErrorException.class)
	  public final ResponseEntity<ErrorDetails> handleInternalServerErrorException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(ObjectNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ObjectNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND,new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(BadRequestException.class)
	  public final ResponseEntity<ErrorDetails> handleBadrequestErrorException(Exception ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	  }

}
