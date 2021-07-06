package com.infy.service;

import java.text.ParseException;
import java.util.List;

import com.infy.DTO.CardDTO;

public interface CardService {
	public CardDTO addCardDetails(Integer userId, CardDTO data) throws ParseException;
	public List<CardDTO> getCardByuserId(Integer userId);
	public CardDTO deleteCardDetails(String cardId);
}
