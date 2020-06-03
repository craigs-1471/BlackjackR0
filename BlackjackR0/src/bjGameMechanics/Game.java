package bjGameMechanics;

import javax.swing.JOptionPane;

import bjObjects.Dealer;
import bjObjects.Deck;
import bjObjects.Player;

public class Game {
	
	// Game fields
	private Deck deck;
	private Player player;
	private Dealer dealer;
	
	// Constructor
	public Game() {
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
	}
	
	// Methods 
	public void deal() {
		String card1 = getDeck().drawCard();
		String card2 = getDeck().drawCard();
		
		String card3 = getDeck().drawCard();
		String card4 = getDeck().drawCard();
		
		getPlayer().addCard(card1, card2);
		getPlayer().setDealtHandValue();
		
		getDealer().addCard(card3, card4);
		getDealer().setDealtHandValue();
	}
	
	public void playerTwist() {
		String card = getDeck().drawCard();
		getPlayer().addCard(card);
		getPlayer().setTwistHandValue();
	}
	
	public void resetGame() {
		getPlayer().resetValues();
		getDealer().resetValues();
	}
	
//	public void dealerTwist() {
//		String card = getDeck().drawCard();
//		//getDealer().addCard(card);
//		//getDealer().setTwistHandValue();
//	}
//	
//	public String getCurrentHands() {
//		String output;
//		output = getPlayer().currentPlayerHandToString() + "\n";
//		//output += getDealer().currentDealerHandToString();
//		return output;
//	}
//	
//	public void playRound() {
//		
//		int userChoice = 0;
//		String output;
//		
//		deal();
//		System.out.println(getPlayer().isBust());
//		do {
//			output = getCurrentHands();
//			output += "\nWould you like to twist?";
//			userChoice = JOptionPane.showConfirmDialog(null, output, "Black Jack!", JOptionPane.YES_NO_OPTION);
//			System.out.println(userChoice);
//			if(userChoice == 0) {
//				playerTwist();
//				System.out.println(getPlayer().isBust());
//				if(getPlayer().isBust()) {
//					output = getPlayer().currentPlayerHandToString() + " Game over.";
//				}
//			}
//		} while(userChoice == 0);
//		
//	}
	
	// Generate getters and setters
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
}
