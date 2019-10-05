package com.skilldistillery.blackjack;


import com.skilldistillery.blackjack.Rank;
import com.skilldistillery.blackjack.Suit;

public class Card {
	private Suit suit;
	private Rank rank;
	
	
	
	public Card(Suit s, Rank rank) {
		this.suit = s;
		this.rank = rank;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank.getValue();
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}



	public Suit getSuit() {
		return suit;
	}



	public void setSuit(Suit suit) {
		this.suit = suit;
	}



	public Rank getRank() {
		return rank;
	}



	public void setRank(Rank rank) {
		this.rank = rank;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank).append(" of ").append(suit);
		return builder.toString();
	}
	
	

}
