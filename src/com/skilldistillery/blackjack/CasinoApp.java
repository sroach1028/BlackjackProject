package com.skilldistillery.blackjack;

public class CasinoApp {
	private BlackJackTable bjt = new BlackJackTable();
	public static void main(String[] args) {
		CasinoApp casino = new CasinoApp();
		casino.launch();
	}
	void launch() {
		bjt.startGame();
	}

}
