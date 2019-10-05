package com.skilldistillery.blackjack;


public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	Suit(String suit) {
		name = suit;
	}

	final private String name;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}