package bjGUI;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import bjGameMechanics.Game;
import bjObjects.Card;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ApplicationWindow {

	private JFrame frame;
	private JButton btnDeal;
	private JPanel pnlDealtCards;
	private Game game;

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
				
				game = new Game();
				game.deal();
				
				Card cardOne = new Card(game.getPlayer().getCurrentHand().get(0));
				Card cardTwo = new Card(game.getPlayer().getCurrentHand().get(1));
				
				pnlDealtCards.setLayout(new GridLayout(1,2));
				pnlDealtCards.add(cardOne);
				pnlDealtCards.add(cardTwo);
				pnlDealtCards.setVisible(true);
				frame.setVisible(true);
				
			}
		});
		btnDeal.setBounds(101, 396, 89, 23);
		frame.getContentPane().add(btnDeal);
		
		pnlDealtCards = new JPanel();
		pnlDealtCards.setBounds(49, 230, 200, 155);
		frame.getContentPane().add(pnlDealtCards);
		
		JLabel lblCurrentTotal = new JLabel("Current Total = ");
		lblCurrentTotal.setBounds(51, 83, 98, 14);
		frame.getContentPane().add(lblCurrentTotal);
	}
}
