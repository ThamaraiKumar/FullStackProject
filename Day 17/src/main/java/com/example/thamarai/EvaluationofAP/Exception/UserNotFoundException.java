package com.example.thamarai.EvaluationofAP.Exception;

public class UserNotFoundException extends Exception {
	  
	   private String message;

	    public UserNotFoundException(String message){
	        super(message);
	        this.message=message;
	    }

	    public UserNotFoundException() {}
	

}
