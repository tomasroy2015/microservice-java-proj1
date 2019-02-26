package jp.co.linkstaff.iis.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Roy
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {
	  public ServerErrorException(String exception) {
		    super(exception);
		  }
	}