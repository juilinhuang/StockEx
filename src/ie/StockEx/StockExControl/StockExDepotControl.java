package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ie.StockEx.AccountManagement.*;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;

public class StockExDepotControl {
	private StockExDepotUI sdf;
	private Trader trader;
	public StockExDepotControl(StockExDepotUI sd, Trader t) {
		trader = t;
		sdf = sd;
		sdf.addLogoutButtonListener(new LogoutListener());
		sdf.addMainButtonListener(new MainListener());
		sdf.addBuyPremiumButtonListener(new BuyPremiumListerner());
	}

	// .......................................................................TODO repeat code
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
			new StockExMainViewControl(smf, trader);
			smf.setVisible(true);
			sdf.dispose();
		}
	}
	
	class BuyPremiumListerner implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//TODO finish this
			IBuyPremium b = (IBuyPremium) trader;
			b.buyPremiumYearly("123456");
			System.out.println("test");
			
		}
	}
}
