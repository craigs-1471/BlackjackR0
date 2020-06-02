package bjObjects;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {
	
	ImageIcon cardImage;
	String card;
	int cardValue;
	
	public Card() {}
	
	public Card(String card) {
		//lblShowImage.setIcon(new ImageIcon(MainApp.class.getResource("/bsResources/220px-USS_Deyo;0598917.jpg")));
		
		String imageFilePath = "/imgCards/" + card + ".jpg";
		cardImage = new ImageIcon(this.getClass().getResource(imageFilePath));
		setIcon(cardImage);
	}
	
}
