package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		sdf.addTableListener(new TableListener());
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
			System.out.println(b.buyPremiumYearly("123456"));
		}
	}
	
	class TableListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent arg0) {
			sdf.getStockLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 0).toString());
			sdf.getPriceLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 1).toString());
			sdf.getSpinner().setModel(new SpinnerNumberModel(1, 1, Integer.parseInt(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 1).toString()), 1));
		}
	}
}
