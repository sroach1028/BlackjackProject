package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.Dealer;
import com.skilldistillery.blackjack.Player;

public class BlackJackTable {
	private Player p1 = new Player();
	private Dealer dealer = new Dealer();

	public void startGame() {
		dealer.deck.shuffle();
		System.out.println("Let's play blackjack! Cards are shuffled. Dealing out\n...\n...");
		dealHands();
	}

	public void dealHands() {
		p1.addCard(dealer.deck.dealCard());
		dealer.addCard(dealer.deck.dealCard());
		p1.addCard(dealer.deck.dealCard());
		p1.showCards();
		dealer.addCard(dealer.deck.dealCard());
		dealer.showOneCard();
		play();
	}

	public void play() {
		do {
			playerPlays();
			if (p1.hand.isBust()) {
				System.out.println(p1.hand.getValue() + " player busts\nDealer Wins..");
				System.out.println();
			} else {

				checkForWinner();
			}
		} while (playAgain());

	}

	public void playerPlays() {
		Scanner kb = new Scanner(System.in);
		while (!p1.hand.isBust()) {
			System.out.println("\nPlayer has " + p1.hand.getValue());
			System.out.println("1. Hit\n2. Stay");
			switch (kb.nextInt()) {
			case 1:
				p1.hit(dealer.deck.dealCard());
				break;
			case 2:
				System.out.println("Player stays at " + p1.hand.getValue());
				dealerPlays();
			}
			if (p1.hand.is21()) {
				System.out.println("Player has 21, dealer turn");
				dealerPlays();
			}
		}

	}

	public void dealerPlays() {
		dealer.showCards();
		while (!dealer.hand.isBust()) {

			if (!dealer.hand.is17()) {
				dealer.hit(dealer.deck.dealCard());
				dealer.showCards();
			}

			else {
				checkForWinner();
			}

		}
		if (dealer.hand.isBust()) {
			System.out.println(dealer.hand.getValue() + " Dealer Busts\nPlayer Wins!");
			playAgain();
		}
	}

	public void checkForWinner() {
		System.out.println("Dealer has " + dealer.hand.getValue());
		if (p1.hand.getValue() > dealer.hand.getValue()) {
			System.out.println("Player wins");
			playAgain();
		} else if (p1.hand.getValue() < dealer.hand.getValue()) {
			System.out.println("Dealer wins");
			playAgain();
		} else if (p1.hand.getValue() == dealer.hand.getValue()) {
			System.out.println("Push");
			playAgain();
		}
	}

	private boolean playAgain() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Play again, 'y' or 'n': ");
		switch (kb.next()) {
		case "y":
		case "Y":
			p1.hand.discardHand();
			dealer.hand.discardHand();
			dealHands();
		case "N":
		case "n":
			System.out.println("Goodbye");
			System.exit(0);
		}
		return false;
	}

}
