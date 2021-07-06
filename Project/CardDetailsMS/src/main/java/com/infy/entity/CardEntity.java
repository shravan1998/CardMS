package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.infy.DTO.CardDTO;

@Entity
@Table(name="Card")
public class CardEntity {

      @Id
      String cardId;
      Long cardNumber;
      Integer userId;
	  String nameOnCard;
	  String expiryDate;
	  Boolean isExpiry;

    public CardEntity() {}

	
	public CardEntity(String cardId, Long cardNumber, Integer userId, String nameOnCard, String expiryDate,
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
		return "MSEntity [cardId=" + cardId + ", cardNumber=" + cardNumber + ", userId=" + userId + ", nameOnCard="
				+ nameOnCard + ", expiryDate=" + expiryDate + ", isExpiry=" + isExpiry + "]";
	}

	public static CardDTO prepareDTO(CardEntity cardEntity) {
		CardDTO cardvalue = new CardDTO();
		cardvalue.setCardNumber(cardEntity.getCardNumber());
		cardvalue.setExpiryDate(cardEntity.getExpiryDate());
		cardvalue.setIsExpiry(cardEntity.getIsExpiry());
		cardvalue.setNameOnCard(cardEntity.getNameOnCard());
		cardvalue.setUserId(cardEntity.getUserId());
		cardvalue.setCardId(cardEntity.getCardId());
		return cardvalue;
	}
}
