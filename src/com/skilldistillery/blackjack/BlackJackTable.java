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

	public void play() {
		do {

			System.out.println("\nDealing cards...");
			dealHands();

			if (p1.hand.isBlackJack() && dealer.hand.isBlackJack()) {
				dealer.showCards();
				System.out.println("\nPlayer has blackjack...Dealer has blackjack. Push");
				discardHands();
				continue;
			} else if (p1.hand.isBlackJack()) {
				System.out.println("\nPlayer has Blackjack, player wins");
				discardHands();
				continue;
			}

			else if (dealer.hand.isBlackJack()) {
				dealer.showCards();
				System.out.println("\nDealer has BlackJack...dealer wins...");
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

	public void dealHands() {
		p1.addCard(dealer.deck.dealCard());
		dealer.addCard(dealer.deck.dealCard());
		p1.addCard(dealer.deck.dealCard());
		p1.showCards();
		dealer.addCard(dealer.deck.dealCard());
		dealer.showOneCard();
	}

	public void playerPlays() {
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("\nPlayer has " + p1.hand.getValue());
			System.out.println("\n1. Hit\n2. Stay");
			int choice = kb.nextInt();
			if (choice == 1) {
				p1.hit(dealer.deck.dealCard());
			}
			if (choice == 2) {
				System.out.println("\nPlayer stays at " + p1.hand.getValue());
				break;
			}

			if (p1.hand.is21()) {
				System.out.println("\nPlayer has 21, dealer turn\n");
				break;
			}
		} while (!p1.hand.isBust());
	}

	public void dealerPlays() {
		dealer.showCards();
		do {

			if (!dealer.hand.is17()) {
				dealer.hit(dealer.deck.dealCard());
				dealer.showCards();
				continue;
			}

			else {
				break;
			}

		} while (!dealer.hand.isBust());
	}

	public void checkForWinner() {
		System.out.println("\nDealer has  " + dealer.hand.getValue());
		if (p1.hand.getValue() > dealer.hand.getValue()) {
			System.out.println("\nPlayer wins");
		} else if (p1.hand.getValue() < dealer.hand.getValue()) {
			System.out.println("\nDealer wins");
		} else if (p1.hand.getValue() == dealer.hand.getValue()) {
			System.out.println("\nPush");
		}
	}

	private boolean playAgain() {
		Scanner kb = new Scanner(System.in);
		System.out.println("\nPlay again, 'y' or 'n': ");
		switch (kb.next()) {
		case "y":
		case "Y":
			return true;
		case "N":
		case "n":
			System.out.println("\nGoodbye...");
			break;
		}
		return false;
	}

	public void discardHands() {
		p1.hand.discardHand();
		dealer.hand.discardHand();
	}

}
