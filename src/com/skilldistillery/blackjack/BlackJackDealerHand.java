package com.skilldistillery.blackjack;


import java.util.ArrayList;

public class BlackJackDealerHand extends BlackJackHand{

	public BlackJackDealerHand() {
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
		boolean isBust = false;
		if (this.getValue()> 21) {
		isBust = true;
		}
		return isBust;
	}
	
	public boolean isBlackJack() {
		return false;
	}
	
	public boolean is21() {
		return this.getValue()==21; 
	}
	
	public boolean is17() {
		boolean is17 = false;
		if(this.getValue()>=17) {
			is17 = true;
		}
		return is17;
	}
}



