package com.skilldistillery.blackjack;

public class Player {
	BlackJackHand hand;
	

	public Player() {
		this.hand = new BlackJackHand();
	}
	
	public void addCard(Card card) {
		this.hand.addCard(card);
	}
	
	public void showCards() {
		
		System.out.println("Player has " + hand.toString());
	}
	
	public void hit(Card card) {
		this.hand.addCard(card);
		showCards();
	}
	

}


