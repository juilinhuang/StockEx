package ie.StockEx.StockExControl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ie.StockEx.StockExUI.StockExMainViewUI;
import ie.StockEx.StockExUI.StockExLogninUI;

public class StockExLoginControl {
	private StockExLogninUI sLogin;
	private String userID;
	private char[] password;

	public StockExLoginControl(StockExLogninUI inUI) {
		sLogin = inUI;
		sLogin.addLoginButtonListener(new LoginListener());
	}

	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			userID = sLogin.getUserName();
			password = sLogin.getPassword();
			String psw = new String(password);
			// if(userID.length() > 0 && password.length > 0)
			
			if(userID.length() <= 0){
				JOptionPane.showMessageDialog(null, "Enter username!");
				sLogin.init();
			}
			else if(password.length <= 0){
				JOptionPane.showMessageDialog(null, "Enter password!");
				sLogin.init();
			}
			else if (userID.equals("1234") && psw.equals("5678")){
				
				System.out.println(userID);
				System.out.println(password);
				StockExMainViewUI smf = new StockExMainViewUI();
				new StockExMainViewControl(smf);
				smf.setVisible(true);
				sLogin.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong username or password!");
				sLogin.init();
			}
			
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				StockExLogninUI slf = new StockExLogninUI();
				new StockExLoginControl(slf);
				slf.setVisible(true);

			}
		});
	}
}
