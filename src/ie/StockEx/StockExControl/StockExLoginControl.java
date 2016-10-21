package ie.StockEx.StockExControl;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ie.StockEx.StockExUI.StockExMainViewUI;
import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.StockExUI.StockExLogninUI;

public class StockExLoginControl {
	private StockExLogninUI sLogin;
	private String userID;
	private AccountManager accountManager;
	private char[] password;

	public StockExLoginControl(StockExLogninUI inUI, AccountManager inAM) {
		sLogin = inUI;
		sLogin.addLoginButtonListener(new LoginListener());
		accountManager = inAM;
	}

	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			userID = sLogin.getUserName();
			password = sLogin.getPassword();
			String psw = new String(password);
			try {
				if (accountManager.loginTrader(userID, psw) != null) {
					System.out.println("456:"+accountManager.loginTrader(userID, psw).hashCode());
					StockExMainViewUI smf = new StockExMainViewUI();
					new StockExMainViewControl(smf);
					smf.setVisible(true);
					sLogin.init();
					sLogin.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "wrong username or password.");
					sLogin.init();
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				sLogin.init();
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				StockExLogninUI slf = new StockExLogninUI();
				AccountManager am = AccountManager.getInstance();
				new StockExLoginControl(slf, am);
				slf.setVisible(true);

			}
		});
	}
}
