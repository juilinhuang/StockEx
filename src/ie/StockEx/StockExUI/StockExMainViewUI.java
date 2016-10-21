package ie.StockEx.StockExUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class StockExMainViewUI extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;

	/**
	 * Create the frame.
	 */
	public StockExMainViewUI() {
		setTitle("StockEX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		logoutButton = new JButton("Logout");
		logoutButton.setBounds(485, 11, 89, 23);
		contentPane.add(logoutButton);
	}

	public void addLogoutButtonListener(ActionListener inLis) {
		logoutButton.addActionListener(inLis);
	}
}
