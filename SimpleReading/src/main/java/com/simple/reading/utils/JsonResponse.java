package com.simple.reading.utils;

public class JsonResponse {
	private String status;
	private String responseMessage;

	public JsonResponse() {

	}

	public JsonResponse(String status, String responseMessage) {

		this.status = status;
		this.responseMessage = responseMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
