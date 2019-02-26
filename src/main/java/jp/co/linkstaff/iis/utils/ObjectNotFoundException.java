package jp.co.linkstaff.iis.utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {
	  public ObjectNotFoundException(String exception) {
	    super(exception);
	  }
}
