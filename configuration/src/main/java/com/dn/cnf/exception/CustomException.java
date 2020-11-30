package com.dn.cnf.exception;

/**
 * 自定义异常类
 * 
 * @author allen
 *
 */
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
