package TelephonicManagement.Models;

public class ApiResponse {
	
	
	private String message;
	private boolean Success;

	public ApiResponse(String message,boolean Success ) {//
		this.message=message;
		this.Success=Success; 
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
//
//	public boolean isSuccess() {
//		return Success;
//	}
//
//	public void setSuccess(boolean success) {
//		Success = success;
//	}
	
	
	
}
