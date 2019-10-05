package com.skilldistillery.blackjack;


import java.util.List;

public abstract class Hand {
	List<Card> cards;
	
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void discardHand() {
		
	}
	
	abstract int getValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(cards);
		return builder.toString();
	}
	
	

}
