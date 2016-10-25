package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.AccountManagement.Trader;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;

public class StockExMainViewControl {

	private StockExMainViewUI smf;
	private Trader trader;
	public StockExMainViewControl(StockExMainViewUI mv, Trader t) {
		trader = t;
		smf = mv;
		smf.addLogoutButtonListener(new LogoutListener());
		smf.addDepotButtonListener(new DeoptListener());
		smf.addTableListener(new TableListener());
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

	class TableListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent arg0) {
			smf.getStockLabel().setText(smf.getTable().getValueAt(smf.getTable().getSelectedRow(), 0).toString());
			smf.getPriceLabel().setText(smf.getTable().getValueAt(smf.getTable().getSelectedRow(), 1).toString());
		}
		
	}
	// ..................................................................................
	class DeoptListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			StockExDepotUI sdf = new StockExDepotUI();
			new StockExDepotControl(sdf, trader);
			sdf.setVisible(true);
			smf.dispose();
		}
	}

}
