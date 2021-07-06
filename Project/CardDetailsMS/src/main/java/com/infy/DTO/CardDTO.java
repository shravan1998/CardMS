package com.infy.DTO;

import org.springframework.stereotype.Component;
import com.infy.entity.CardEntity;

@Component
public class CardDTO {
	 
	      String cardId;
	      Long cardNumber;
	      Integer userId;
		  String nameOnCard;
		  String expiryDate;
		  Boolean isExpiry;
	  
	  public CardDTO() {}
    	

	public CardDTO(String cardId, Long cardNumber, Integer userId, String nameOnCard, String expiryDate,
			Boolean isExpiry) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.userId = userId;
		this.nameOnCard = nameOnCard;
		this.expiryDate = expiryDate;
		this.isExpiry = isExpiry;
	}

	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public Long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Boolean getIsExpiry() {
		return isExpiry;
	}


	public void setIsExpiry(Boolean isExpiry) {
		this.isExpiry = isExpiry;
	}
	
	@Override
	public String toString() {
		return "MSDTO [cardId=" + cardId + ", cardNumber=" + cardNumber + ", userId=" + userId + ", nameOnCard="
				+ nameOnCard + ", expiryDate=" + expiryDate + ", isExpiry=" + isExpiry + "]";
	}

	public static CardEntity prepareEntity(CardDTO cardDTO) {
		CardEntity cardvalue = new CardEntity();
		cardvalue.setCardNumber(cardDTO.getCardNumber());
		cardvalue.setExpiryDate(cardDTO.getExpiryDate());
		cardvalue.setIsExpiry(cardDTO.getIsExpiry());
		cardvalue.setNameOnCard(cardDTO.getNameOnCard());
		cardvalue.setUserId(cardDTO.getUserId());
		cardvalue.setCardId(cardDTO.getCardId());
		return cardvalue;
	}
	  
}
