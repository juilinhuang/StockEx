package ie.StockEx.StockExUI;

import java.awt.EventQueue;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.StockExControl.StockExLoginControl;

public class StockExMain {

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
