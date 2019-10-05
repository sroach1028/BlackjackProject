package com.skilldistillery.blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.blackjack.Rank;
import com.skilldistillery.blackjack.Suit;

public class Deck {
List<Card> cardDeck;


	public Deck() {
		
		cardDeck = new ArrayList<>(52);
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				Card nextCard = new Card(s, r);
				cardDeck.add(nextCard);
			}
		}
	}
	
	public int checkDeckSize() {
		return this.cardDeck.size();
	}

	public Card dealCard() {
		return this.cardDeck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(this.cardDeck);
	}
}
