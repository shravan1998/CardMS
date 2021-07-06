package com.infy.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.DTO.CardDTO;
import com.infy.customResponse.CustomMessage;
import com.infy.service.CardService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin
@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	
/////////////////////////////////////////////////////TO ADD CARD///////////////////////////////////////////////
//////////////////////////////////// (POST) - http://localhost:8400/card/add/1 ////////////////////////////////	
	
	
	@HystrixCommand(fallbackMethod="addCardFallBack")
	@PostMapping("/add/{userId}")
	public ResponseEntity<CustomMessage> addCard(@PathVariable("userId") Integer userId, @RequestBody CardDTO data) throws Exception {
		// we have to check whether user exist or not
		CardDTO value = cardService.addCardDetails(userId, data);
		 CustomMessage messageData = errorResponse("Card Added In DataBase Successfully", "Success", value);
		return new  ResponseEntity<CustomMessage>(messageData, HttpStatus.CREATED);	
	}
	
	public ResponseEntity<CustomMessage> addCardFallBack(Integer userId, CardDTO data){
		 CustomMessage messageData = errorResponse("Card you have entered is not valid, Fallback occur", "Fail", null); 
		return new  ResponseEntity<CustomMessage>(messageData, HttpStatus.OK);
	}
	
	
/////////////////////////////////////////////////////TO FIND CARD///////////////////////////////////////////////
/////////////////////////////////// (Get) - http://localhost:8400/card/getByUserId/1 //////////////////////////
	
	
	@HystrixCommand(fallbackMethod="getCardByuserIdFallBack")
    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<CustomMessage> getCardByuserId(@PathVariable("userId") Integer userId) throws Exception {
		// we have to check whether user exist or not
		List<CardDTO> value = cardService.getCardByuserId(userId);
    	 CustomMessage messageData = errorResponse("Card Received Successfully", "Success", value);
    	return new ResponseEntity<CustomMessage>(messageData, HttpStatus.OK);	
    }
	
	 public ResponseEntity<CustomMessage> getCardByuserIdFallBack(Integer userId){
		 CustomMessage messageData = errorResponse("User does not exist, Fallback occur", "Fail", null);
			return new  ResponseEntity<CustomMessage>(messageData, HttpStatus.OK);
	 }
	 
	 
/////////////////////////////////////////////////////TO DELETE CARD///////////////////////////////////////////////
/////////////////////////////////// (Delete) - http://localhost:8400/card/deleteById/c1 /////////////////////////

	 
	@HystrixCommand(fallbackMethod="deleteCardByIdFallBack")
    @DeleteMapping("/deleteById/{cardId}")
    public ResponseEntity<CustomMessage> deleteCardById(@PathVariable("cardId") String cardId) throws Exception {
    	CardDTO value = cardService.deleteCardDetails(cardId);
   	 CustomMessage messageData = errorResponse("Card Deleted Successfully", "Success", value);
    	return new ResponseEntity<CustomMessage>(messageData, HttpStatus.OK);	
    }
	
	 public ResponseEntity<CustomMessage> deleteCardByIdFallBack(String cardId){
		 CustomMessage messageData = errorResponse("Card does not exist, Fallback occur", "Fail", null);
			return new  ResponseEntity<CustomMessage>(messageData, HttpStatus.OK);
	 }
	 
	 
///////////////////////////////////////////CUSTOM RESPONSE////////////////////////////////////////////////	
		
		
 public String dateAndTimeStamp() {
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
     LocalDateTime now = LocalDateTime.now();  
     return dtf.format(now);
 }

 public CustomMessage errorResponse(String customMessage, String status, Object data) {
	 CustomMessage mesg = new CustomMessage();
     mesg.setMessage(customMessage);
     mesg.setTimeStamp(dateAndTimeStamp());
     mesg.setStatus(status);
     mesg.setData(data);
     return mesg;
 }

}
