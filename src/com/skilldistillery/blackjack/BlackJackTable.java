package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.Dealer;
import com.skilldistillery.blackjack.Player;

public class BlackJackTable {
	private Player p1 = new Player();
	private Dealer dealer = new Dealer();

	public void startGame() {
		dealer.getDeck().shuffle();
		System.out.println("Let's play blackjack! Cards are shuffled.");
		play();
	}

	public void play() {
		do {

			System.out.println("\nDealing cards...");
			dealHands();

			if (p1.getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
				dealer.showCards();
				System.out.println("\nPlayer has blackjack...Dealer has blackjack. Push");
				discardHands();
				continue;
			} else if (p1.getHand().isBlackJack()) {
				System.out.println("\nPlayer has Blackjack, player wins");
				discardHands();
				continue;
			}

			else if (dealer.getHand().isBlackJack()) {
				dealer.showCards();
				System.out.println("\nDealer has BlackJack...dealer wins...");
				discardHands();
				continue;
			}

			else {
				playerPlays();
			}

			if (p1.getHand().isBust()) {
				System.out.println(p1.getHand().getValue() + " player busts\nDealer Wins..\n");
				p1.getHand().discardHand();
				dealer.getHand().discardHand();
				continue;
			} else {

				dealerPlays();

			}

			if (dealer.getHand().isBust()) {
				System.out.println(dealer.getHand().getValue() + " Dealer Busts\nPlayer Wins!");
				p1.getHand().discardHand();
				dealer.getHand().discardHand();
				continue;
			} else {
				checkForWinner();
				p1.getHand().discardHand();
				dealer.getHand().discardHand();
			}

		} while (playAgain());

	}

	public void dealHands() {
		p1.addCard(dealer.getDeck().dealCard());
		dealer.addCard(dealer.getDeck().dealCard());
		p1.addCard(dealer.getDeck().dealCard());
		p1.showCards();
		dealer.addCard(dealer.getDeck().dealCard());
		dealer.showOneCard();
	}

	public void playerPlays() {
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("\nPlayer has " + p1.getHand().getValue());
			System.out.println("\n1. Hit\n2. Stay");
			int choice = kb.nextInt();
			if (choice == 1) {
				p1.hit(dealer.getDeck().dealCard());
			}
			if (choice == 2) {
				System.out.println("\nPlayer stays at " + p1.getHand().getValue());
				break;
			}

			if (p1.getHand().is21()) {
				System.out.println("\nPlayer has 21, dealer turn\n");
				break;
			}
		} while (!p1.getHand().isBust());
	}

	public void dealerPlays() {
		dealer.showCards();
		do {

			if (!dealer.getHand().is17()) {
				dealer.hit(dealer.getDeck().dealCard());
				dealer.showCards();
				continue;
			}

			else {
				break;
			}

		} while (!dealer.getHand().isBust());
	}

	public void checkForWinner() {
		System.out.println("\nDealer has  " + dealer.getHand().getValue());
		if (p1.getHand().getValue() > dealer.getHand().getValue()) {
			System.out.println("\nPlayer wins");
		} else if (p1.getHand().getValue() < dealer.getHand().getValue()) {
			System.out.println("\nDealer wins");
		} else if (p1.getHand().getValue() == dealer.getHand().getValue()) {
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
		p1.getHand().discardHand();
		dealer.getHand().discardHand();
	}

}
