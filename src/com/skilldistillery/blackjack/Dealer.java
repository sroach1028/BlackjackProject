package com.skilldistillery.blackjack;


import java.util.Scanner;

import com.skilldistillery.blackjack.BlackJackDealerHand;
import com.skilldistillery.blackjack.Deck;

public class Dealer{
	private Deck deck;
	private BlackJackDealerHand hand;
	
	public Dealer() {
		this.deck = new Deck();
		this.hand = new BlackJackDealerHand();
	}
	
	public Deck getDeck() {
		return this.deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public BlackJackDealerHand getHand() {
		return this.hand;
	}

	public void setHand(BlackJackDealerHand hand) {
		this.hand = hand;
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


