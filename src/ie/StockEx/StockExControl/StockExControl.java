package ie.StockEx.StockExControl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ie.StockEx.StockExUI.StockExLogninUI;

public class StockExControl {
	private StockExLogninUI sLogin;
	private String userID;
	private char[] password;
	public StockExControl(StockExLogninUI inUI){
		sLogin = inUI;
		sLogin.addLoginButtonListener(new LoginListener());
	}
	
	class LoginListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			userID = sLogin.getUserName();
			password = sLogin.getPassword();
			System.out.println(userID);
			System.out.println(password);
			//sLogin.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockExLogninUI frame = new StockExLogninUI();
					StockExControl c = new StockExControl(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
