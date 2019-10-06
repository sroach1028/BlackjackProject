package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.Dealer;
import com.skilldistillery.blackjack.Player;

public class BlackJackTable {
	private Player p1 = new Player();
	private Dealer dealer = new Dealer();

	public void startGame() {
		dealer.deck.shuffle();
		System.out.println("Let's play blackjack! Cards are shuffled.");
		play();
	}

	public void dealHands() {
		p1.addCard(dealer.deck.dealCard());
		dealer.addCard(dealer.deck.dealCard());
		p1.addCard(dealer.deck.dealCard());
		p1.showCards();
		dealer.addCard(dealer.deck.dealCard());
		dealer.showOneCard();
	}

	public void play() {
		do {

			System.out.println("\n/Dealing cards...");
			dealHands();

			if (p1.hand.isBlackJack() && dealer.hand.isBlackJack()) {
				dealer.showCards();
				System.out.println("Player has blackjack...Dealer has blackjack. Push");
				discardHands();
				continue;
			} else if (p1.hand.isBlackJack()) {
				System.out.println("Player has Blackjack, player wins");
				discardHands();
				continue;
			}

			else if (dealer.hand.isBlackJack()) {
				dealer.showCards();
				System.out.println("Dealer has BlackJack...dealer wins...");
				discardHands();
				continue;
			}

			else {
				playerPlays();
			}

			if (p1.hand.isBust()) {
				System.out.println(p1.hand.getValue() + " player busts\nDealer Wins..\n");
				p1.hand.discardHand();
				dealer.hand.discardHand();
				continue;
			} else {
				dealerPlays();
				
			}

			if (dealer.hand.isBust()) {
				System.out.println(dealer.hand.getValue() + " Dealer Busts\nPlayer Wins!");
				p1.hand.discardHand();
				dealer.hand.discardHand();
				continue;
			} else {
				checkForWinner();
				p1.hand.discardHand();
				dealer.hand.discardHand();
			}

		} while (playAgain());

	}

	public void playerPlays() {
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("\nPlayer has " + p1.hand.getValue());
			System.out.println("1. Hit\n2. Stay");
			int choice = kb.nextInt();
			if (choice == 1) {
				p1.hit(dealer.deck.dealCard());
			}
			if (choice == 2) {
				System.out.println("Player stays at " + p1.hand.getValue());
				break;
			}

			if (p1.hand.is21()) {
				System.out.println("Player has 21, dealer turn\n");
				break;
			}
		} while (!p1.hand.isBust());
	}

	public void dealerPlays() {
		do {

			dealer.showCards();

			if (!dealer.hand.is17()) {
				dealer.hit(dealer.deck.dealCard());
				continue;
			}

			else {
				break;
			}

		} while (!dealer.hand.isBust());
		dealer.showCards();
	}

	public void checkForWinner() {
		System.out.println("dealer has  " + dealer.hand.getValue());
		if (p1.hand.getValue() > dealer.hand.getValue()) {
			System.out.println("Player wins");
		} else if (p1.hand.getValue() < dealer.hand.getValue()) {
			System.out.println("Dealer wins");
		} else if (p1.hand.getValue() == dealer.hand.getValue()) {
			System.out.println("Push");
		}
	}

	private boolean playAgain() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Play again, 'y' or 'n': ");
		switch (kb.next()) {
		case "y":
		case "Y":
			return true;
		case "N":
		case "n":
			System.out.println("Goodbye...");
			break;
		}
		return false;
	}
	
	public void discardHands() {
		p1.hand.discardHand();
		dealer.hand.discardHand();
	}

}
