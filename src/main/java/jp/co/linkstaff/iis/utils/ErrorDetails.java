package jp.co.linkstaff.iis.utils;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Roy
 *
 */
public class ErrorDetails {
	  private HttpStatus status;
	  private Date timestamp;
	  private String message;
	  private String details;

	  public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorDetails(HttpStatus status,Date timestamp, String message, String details) {
	    super();
	    this.status = status;
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	  }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
