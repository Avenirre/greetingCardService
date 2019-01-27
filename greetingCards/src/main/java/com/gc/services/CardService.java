package com.gc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gc.model.Card;
import com.gc.repositories.CardRepository;

@Service
public class CardService {
	
	CardRepository cards;
	
	public CardService(CardRepository cards) {
		this.cards = cards;
	}
	
	public void saveCard(Card card) {
		cards.save(card);
	}

	public List<Card> getCards() {
		List<Card> result = new ArrayList<>();
		cards.findAll().iterator().forEachRemaining(result::add);
		return result;
	}
}
