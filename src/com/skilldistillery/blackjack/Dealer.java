package com.skilldistillery.blackjack;


import java.util.Scanner;

import com.skilldistillery.blackjack.BlackJackDealerHand;
import com.skilldistillery.blackjack.Deck;

public class Dealer{
	Deck deck;
	BlackJackDealerHand hand;
	
	public Dealer() {
		this.deck = new Deck();
		this.hand = new BlackJackDealerHand();
	}
	
	public void addCard(Card card) {
		this.hand.addCard(card);
	}
	
	public void showOneCard() {
		System.out.println("Dealer shows " + hand.cards.get(0));
	}
	
	public void showCards() {
		System.out.println("Dealer shows " + hand.toString());
	}
	
	
	public void hit(Card card) {
		this.hand.addCard(card);
	}
	
	
	}


