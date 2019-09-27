/**
 * 
 */
package co.com.accounting.util;

import lombok.Data;

/**
 * @author stick
 *
 */
@Data
public class GeneralResponse {
	
	private String status;
	private String message;
	private Object resul;
	
	public GeneralResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public GeneralResponse(String status, String message, Object resul) {
		super();
		this.status = status;
		this.message = message;
		this.resul = resul;
	}
	
}
