package com.infy.customResponse;

public class CustomMessage {
	
	private String timeStamp;
	private String status;
	private String message;
	private Object data;
	
	public CustomMessage() {}
	public CustomMessage(String timeStamp, String status, String message, Object data) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "CustomMessage [timeStamp=" + timeStamp + ", status=" + status + ", message=" + message + ", data="
				+ data + "]";
	}
	
	
}
