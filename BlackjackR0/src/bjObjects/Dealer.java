package bjObjects;

public class Dealer extends Player {
	
	public int initialTotal() {
		int visibleCardValue;
		visibleCardValue = getCardValue(getCurrentHand().get(0));
		return visibleCardValue;
	}
	
	public void dealersTurn() {
		if(getCurrentHandValue() <= 16) {
			
		}
	}
	
}
