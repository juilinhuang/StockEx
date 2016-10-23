package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;

public class StockExDepotControl {
	private StockExDepotUI sdf;

	public StockExDepotControl(StockExDepotUI sd) {
		sdf = sd;
		sdf.addLogoutButtonListener(new LogoutListener());
		sdf.addMainButtonListener(new MainListener());
	}

	// .......................................................................
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			StockExLogninUI slf = new StockExLogninUI();
			AccountManager am = AccountManager.getInstance();
			new StockExLoginControl(slf, am);
			slf.setVisible(true);
			sdf.dispose();
		}
	}
	// .......................................................................

	class MainListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			StockExMainViewUI smf = new StockExMainViewUI();
			new StockExMainViewControl(smf);
			smf.setVisible(true);
			sdf.dispose();
		}
	}
}
