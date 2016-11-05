package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ie.StockEx.AccountManagement.*;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;
import ie.StockEx.StockExchangeConnection.StockExchangeConnector;
import ie.StockEx.StockExchangeConnection.XetraConnector;
import ie.StockEx.StockManagement.Stock;

public class StockExDepotControl {
	private StockExDepotUI sdf;
	private Trader trader;
	private StockExchangeConnector connector;
	
	public StockExDepotControl(StockExDepotUI sd, Trader t) {
		trader = t;
		sdf = sd;
		sdf.addLogoutButtonListener(new LogoutListener());
		sdf.addMainButtonListener(new MainListener());
		sdf.addBuyPremiumButtonListener(new BuyPremiumListener());
		sdf.addsellStockButtonListener(new SellStockListener());
		sdf.addTableListener(new TableListener());
	}

	// .......................................................TODO repeat code
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

	class BuyPremiumListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			IBuyPremium b = (IBuyPremium) trader;
			System.out.println(b.buyPremiumYearly("123456"));
		}
	}

	class SellStockListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Stock s = new Stock(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 0).toString(),
						Double.parseDouble(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 1).toString()), 0,
						new XetraConnector());// TODO add connector
				trader.sellStock(s, Integer.parseInt(sdf.getAmountSpinner().getValue().toString()));
				sdf.getBalanceLable().setText(Double.toString(trader.getDepot().getBalance()));
				System.out.println("sell stock");
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Depot is empty!", "Error", JOptionPane.PLAIN_MESSAGE);;
			}
		}
	}

	class TableListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			sdf.getStockLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 0).toString());
			sdf.getPriceLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 1).toString());
			sdf.getAmountSpinner().setModel(new SpinnerNumberModel(1, 1,
					Integer.parseInt(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 2).toString()), 1));
		}
	}
	
	
}
