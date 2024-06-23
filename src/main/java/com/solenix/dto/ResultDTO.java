/**
 * 
 */
package com.solenix.dto;

/**
 * @author solenix
 *
 */
public class ResultDTO {
	
	private boolean success;
    private String message;
    private Object data;
    
	public ResultDTO(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public Object getData() {
		return data;
	}

}
