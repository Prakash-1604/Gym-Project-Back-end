package com.jsp.Springboot_GYM_App.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.Springboot_GYM_App.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		java.util.List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError error : errors) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(GymIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> gymIdNotFound(GymIdNotFound gymIdNotFound)
	{
		ResponseStructure< String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	     responseStructure.setMessage("entered Id is Wrong");
		responseStructure.setData(gymIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchHeadIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchHeadIdNotFound(BranchHeadIdNotFound branchHeadIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(branchHeadIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound AddressIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(AddressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> trainerIdNotFound(TrainerIdNotFound trainerIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(trainerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MemberShipIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> memberShipIdNotFound(MemberShipIdNotFound memberShipIdNotFound){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Enter Id is Wrong");
		responseStructure.setData(memberShipIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}