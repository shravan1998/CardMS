package com.infy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infy.DTO.CardDTO;
import com.infy.entity.CardEntity;
import com.infy.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;

	
/////////////////////////////////////////////////////TO ADD CARD///////////////////////////////////////////////
	
	
	public CardDTO addCardDetails(Integer userId, CardDTO data) throws ParseException{
		CardEntity value = CardDTO.prepareEntity(data);
		value.setUserId(userId);
		float num = CardServiceImpl.findExpiry(data.getExpiryDate());
		if(num > 0) {
			value.setIsExpiry(false);
		}else {
			value.setIsExpiry(true);
		}
		return CardEntity.prepareDTO(cardRepository.save(value));
	}
	

/////////////////////////////////////////////////////TO FIND CARD///////////////////////////////////////////////
	
	
	public List<CardDTO> getCardByuserId(Integer userId) { //throws ParseException 
		List<CardEntity> data = cardRepository.findByUserId(userId);
		List<CardDTO> value = new ArrayList<>();
		for(CardEntity items: data) {
			value.add(CardEntity.prepareDTO(items));
		}
		return value;
	}
	
	
/////////////////////////////////////////////////////TO DELETE CARD///////////////////////////////////////////////
	
	
	public CardDTO deleteCardDetails(String cardId) {
		cardRepository.deleteById(cardId);
		return null;
	}
	
	
  /////////////////////////////////////////////TO CHECK EXPIRY DATE//////////////////////////////////////////
	
	
	public static float findExpiry(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		String CurrentDate=formatter.format(today);
		String ExpDate=date; 
		Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(ExpDate);  
		Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(CurrentDate); 
		long difference = date1.getTime() - date2.getTime();
		long daysBetween = (difference / (1000*60*60*24));
		return daysBetween;
	} 
}

