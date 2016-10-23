package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sun.javafx.event.EventQueue;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;

public class StockExMainViewControl {

	private StockExMainViewUI smf;

	public StockExMainViewControl(StockExMainViewUI mv) {
		smf = mv;
		smf.addLogoutButtonListener(new LogoutListener());
		smf.addDepotButtonListener(new DeoptListener());
	}

	// ................................................................................
	class LogoutListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			StockExLogninUI slf = new StockExLogninUI();
			AccountManager am = AccountManager.getInstance();
			new StockExLoginControl(slf, am);
			slf.setVisible(true);
			smf.dispose();
		}
	}

	// ..................................................................................
	class DeoptListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			StockExDepotUI sdf = new StockExDepotUI();
			new StockExDepotControl(sdf);
			sdf.setVisible(true);
			smf.dispose();
		}
	}

}
