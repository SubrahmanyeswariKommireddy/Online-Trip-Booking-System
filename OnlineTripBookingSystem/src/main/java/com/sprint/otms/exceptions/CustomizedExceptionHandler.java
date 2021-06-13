package com.sprint.otms.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author Susmitha
 *
 */
@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ExceptionMessage {
	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)

	// Override method of ExceptionMessage class
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		// creating exception response structure
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));

		// returning exception structure and specific status
		return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex,
			WebRequest request) {
		// creating exception response structure
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));

		// returning exception structure and specific status
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> exception(AdminNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = TravelsNotFoundException.class)
	public ResponseEntity<Object> exception(TravelsNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = RouteNotFoundException.class)
	public ResponseEntity<Object> exception(RouteNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = BusNotFoundException.class)
	public ResponseEntity<Object> exception(BusNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = BookingNotFoundException.class)
	public ResponseEntity<Object> exception(BookingNotFoundException ex, WebRequest request) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}
}
