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
	private JPanel pnlPlayerDealtCards;
	private Game game;
	private JLabel lblCurrentPlayerTotal;
	private JPanel pnlPlayerTwistCards;
	private JButton btnTwist;
	private JPanel pnlDealerDealtCards;
	private JPanel pnlDealerTwistCards;
	private JLabel lblcount;
	private JLabel lblCurrentDealerTotal;
	private JButton btnStick;

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
		frame.setBounds(100, 100, 893, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		game = new Game();
		
		btnDeal = new JButton("Deal");
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(game.getPlayer().getCurrentHand().size() == 0) {
					game = new Game();
					game.deal();
					
					String currentCount = "Current Count: ";
					currentCount += game.getDeck().getCount();
					lblcount.setText(currentCount);
					
					Card cardOne = new Card(game.getPlayer().getCurrentHand().get(0));
					Card cardTwo = new Card(game.getPlayer().getCurrentHand().get(1));
					
					String currentTotal = "Current Player Total: ";
					currentTotal += game.getPlayer().getCurrentHandValue();
					lblCurrentPlayerTotal.setText(currentTotal);
					
					pnlPlayerDealtCards.setLayout(new GridLayout(1,2));
					pnlPlayerDealtCards.add(cardOne);
					pnlPlayerDealtCards.add(cardTwo);
					btnDeal.setVisible(false);
					pnlPlayerDealtCards.setVisible(true);
					
					Card cardThree = new Card(game.getDealer().getCurrentHand().get(0));
					Card cardFour = new Card("back");
					
					pnlDealerDealtCards.setLayout(new GridLayout(1,2));
					pnlDealerDealtCards.add(cardThree);
					pnlDealerDealtCards.add(cardFour);
					pnlDealerDealtCards.setVisible(true);
					
					String currentDealerTotal = "Current Dealer Total: ";
					currentDealerTotal += game.getDealer().initialTotal();
					lblCurrentDealerTotal.setText(currentDealerTotal);
					
					btnTwist.setVisible(true);
					btnStick.setVisible(true);
					frame.setVisible(true);
				}
			}
		});
		btnDeal.setBounds(106, 612, 89, 23);
		frame.getContentPane().add(btnDeal);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				game.resetGame();
				String currentTotal = "Current Total: ";
				lblCurrentPlayerTotal.setText(currentTotal);
				pnlPlayerDealtCards.removeAll();
				pnlPlayerTwistCards.removeAll();
				pnlPlayerDealtCards.setVisible(false);
				pnlPlayerDealtCards.setVisible(true);
				pnlPlayerTwistCards.setVisible(false);
				pnlPlayerTwistCards.setVisible(true);
				btnNewGame.setVisible(false);
				btnDeal.setVisible(true);
				frame.setVisible(true);
				
			}
		});
		btnNewGame.setBounds(106, 612, 89, 23);
		frame.getContentPane().add(btnNewGame);
		btnNewGame.setVisible(false);
		
		pnlPlayerDealtCards = new JPanel();
		pnlPlayerDealtCards.setBounds(54, 446, 200, 155);
		frame.getContentPane().add(pnlPlayerDealtCards);
		pnlPlayerDealtCards.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblCurrentPlayerTotal = new JLabel("Current Player Total: ");
		lblCurrentPlayerTotal.setBounds(54, 421, 200, 14);
		frame.getContentPane().add(lblCurrentPlayerTotal);
		
		btnTwist = new JButton("Twist");
		btnTwist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!game.getPlayer().isBust() && game != null) {
					
					game.playerTwist();
					ArrayList<String> currentHand = game.getPlayer().getCurrentHand();
					int numberOfTwistCards = currentHand.size() - 2;
					
					pnlPlayerTwistCards.setLayout(new GridLayout(1, numberOfTwistCards));

					pnlPlayerTwistCards.add(new Card(currentHand.get(currentHand.size() - 1)));
					
					String currentCount = "Current Count: ";
					currentCount += game.getDeck().getCount();
					lblcount.setText(currentCount);
					
					String currentTotal = "Current Total: ";
					currentTotal += game.getPlayer().getCurrentHandValue();
					lblCurrentPlayerTotal.setText(currentTotal);
					
					if(game.getPlayer().isBust()) {
						btnNewGame.setVisible(true);
						btnStick.setVisible(false);
					}
					
					frame.setVisible(true);
					pnlPlayerTwistCards.setVisible(true);
				}
			}
		});
		btnTwist.setBounds(404, 612, 89, 23);
		frame.getContentPane().add(btnTwist);
		btnTwist.setVisible(false);
		
		pnlPlayerTwistCards = new JPanel();
		pnlPlayerTwistCards.setBounds(283, 446, 546, 155);
		frame.getContentPane().add(pnlPlayerTwistCards);
		
		pnlDealerDealtCards = new JPanel();
		pnlDealerDealtCards.setBounds(54, 195, 200, 155);
		frame.getContentPane().add(pnlDealerDealtCards);
		
		pnlDealerTwistCards = new JPanel();
		pnlDealerTwistCards.setBounds(283, 195, 546, 155);
		frame.getContentPane().add(pnlDealerTwistCards);
		
		lblcount = new JLabel("Current Count: ");
		lblcount.setBounds(54, 110, 141, 14);
		frame.getContentPane().add(lblcount);
		
		lblCurrentDealerTotal = new JLabel("Current Dealer Total: ");
		lblCurrentDealerTotal.setBounds(53, 170, 201, 14);
		frame.getContentPane().add(lblCurrentDealerTotal);
		
		btnStick = new JButton("Stick");
		btnStick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pnlDealerDealtCards.remove(1);
				Card secondDealerCard = new Card(game.getDealer().getCurrentHand().get(1));
				pnlDealerDealtCards.add(secondDealerCard);
				
				game.dealerGo();
				
				for(int i = 2; i < game.getDealer().getCurrentHand().size(); i++) {
					
					pnlDealerTwistCards.add(new Card(game.getDealer().getCurrentHand().get(i)));
					
				}
				
				
				frame.setVisible(true);
				pnlDealerDealtCards.setVisible(true);
				pnlDealerTwistCards.setVisible(true);
				
				
			}
		});
		btnStick.setBounds(506, 612, 89, 23);
		frame.getContentPane().add(btnStick);
		btnStick.setVisible(false);
	}
}
