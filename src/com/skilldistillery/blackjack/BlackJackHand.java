package com.skilldistillery.blackjack;


import java.util.ArrayList;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Hand;

public class BlackJackHand extends Hand{


	public BlackJackHand() {
		cards = new ArrayList<>();
			
	}
	@Override
	public void addCard(Card newCard) {
		cards.add(newCard);
	}
	
	@Override
	public void discardHand() {
		cards.clear();
	}

	@Override
	int getValue() {
		int total = 0;
		for (Card card : cards) {
			total += card.getRank().getValue();
		}

		return total;
	}
	
	public boolean isBust() {
		
		return (this.getValue()>21);
	}
	
	public boolean isBlackJack() {
		return this.getValue()==21;
	}
	
	public boolean is21() {
		return (this.getValue()==21); 
	}

}
