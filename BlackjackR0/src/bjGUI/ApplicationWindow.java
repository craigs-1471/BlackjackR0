package bjGUI;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import bjGameMechanics.Game;
import bjObjects.Card;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ApplicationWindow {

	private JFrame frame;
	private JButton btnDeal;
	private JButton btnNewGame;
	private JPanel pnlDealtCards;
	private Game game;
	private JLabel lblCurrentTotal;
	private JPanel pnlTwistCards;
	private JButton btnTwist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 887, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnDeal = new JButton("Deal");
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game == null) {
					game = new Game();
					game.deal();
					
					Card cardOne = new Card(game.getPlayer().getCurrentHand().get(0));
					Card cardTwo = new Card(game.getPlayer().getCurrentHand().get(1));
					
					String currentTotal = "Current Total: ";
					currentTotal += game.getPlayer().getCurrentHandValue();
					lblCurrentTotal.setText(currentTotal);
					
					pnlDealtCards.setLayout(new GridLayout(1,2));
					pnlDealtCards.add(cardOne);
					pnlDealtCards.add(cardTwo);
					btnDeal.setVisible(false);
					pnlDealtCards.setVisible(true);
					frame.setVisible(true);
				}
			}
		});
		btnDeal.setBounds(101, 396, 89, 23);
		frame.getContentPane().add(btnDeal);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				game.resetGame();
				pnlDealtCards.removeAll();
				pnlTwistCards.removeAll();
				pnlDealtCards.setVisible(true);
				frame.setVisible(true);
				
			}
		});
		btnNewGame.setBounds(101, 396, 89, 23);
		frame.getContentPane().add(btnNewGame);
		btnNewGame.setVisible(false);
		
		pnlDealtCards = new JPanel();
		pnlDealtCards.setBounds(49, 230, 200, 155);
		frame.getContentPane().add(pnlDealtCards);
		pnlDealtCards.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblCurrentTotal = new JLabel("Current Total = ");
		lblCurrentTotal.setBounds(51, 83, 98, 14);
		frame.getContentPane().add(lblCurrentTotal);
		
		btnTwist = new JButton("Twist");
		btnTwist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!game.getPlayer().isBust() && game != null) {
					
					game.playerTwist();
					ArrayList<String> currentHand = game.getPlayer().getCurrentHand();
					int numberOfTwistCards = currentHand.size() - 2;
					
					pnlTwistCards.setLayout(new GridLayout(1, numberOfTwistCards));

					pnlTwistCards.add(new Card(currentHand.get(currentHand.size() - 1)));
					
					String currentTotal = "Current Total: ";
					currentTotal += game.getPlayer().getCurrentHandValue();
					lblCurrentTotal.setText(currentTotal);
					
					if(game.getPlayer().isBust()) {
						btnNewGame.setVisible(true);
					}
					
					frame.setVisible(true);
					pnlTwistCards.setVisible(true);
				}
			}
		});
		btnTwist.setBounds(503, 396, 89, 23);
		frame.getContentPane().add(btnTwist);
		
		pnlTwistCards = new JPanel();
		pnlTwistCards.setBounds(278, 230, 546, 155);
		frame.getContentPane().add(pnlTwistCards);
	}
	
	
}
