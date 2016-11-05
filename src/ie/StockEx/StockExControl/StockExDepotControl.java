package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ie.StockEx.AccountManagement.*;
import ie.StockEx.StockExUI.StockExDepotUI;
import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;
import ie.StockEx.StockExchangeConnection.StockExchangeConnector;
import ie.StockEx.StockManagement.*;

public class StockExDepotControl {
	private StockExDepotUI sdf;
	private Trader trader;
	
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
			Map<IFinancialProduct, Integer> m = trader.getDepot().getAssets();
			IFinancialProduct[] s = new IFinancialProduct[m.size()];
			int[] q = new int[m.size()];
			int i = 0;
			for (Map.Entry<IFinancialProduct, Integer> ent : m.entrySet()) {
				s[i] = ent.getKey();
				q[i] = ent.getValue();
				i++;
			}
			
			try {
				trader.sellStock((Stock)s[sdf.getTable().getSelectedRow()], Integer.parseInt(sdf.getAmountSpinner().getValue().toString()));
				sdf.getBalanceLable().setText(Double.toString(trader.getDepot().getBalance()));
				System.out.println(s[sdf.getTable().getSelectedRow()].getName()+"sold");
				resetTableData(m);
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Choose a stock", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	class TableListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			try{
			sdf.getStockLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 0).toString());
			sdf.getPriceLabel().setText(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 1).toString());
			sdf.getAmountSpinner().setModel(new SpinnerNumberModel(1, 1,
					Integer.parseInt(sdf.getTable().getValueAt(sdf.getTable().getSelectedRow(), 2).toString()), 1));
			}catch (ArrayIndexOutOfBoundsException e){
				sdf.getStockLabel().setText("");
				sdf.getPriceLabel().setText("");
				sdf.getAmountSpinner().setModel(new SpinnerNumberModel(0,0,0,0));
			}
		}
	}
	
	private void resetTableData(Map<IFinancialProduct, Integer> m){
		((DefaultTableModel) sdf.getTable().getModel()).fireTableDataChanged();
		((DefaultTableModel) sdf.getTable().getModel()).getDataVector().removeAllElements();
		for (Map.Entry<IFinancialProduct, Integer> entry : m.entrySet()) {
			String oo = "";
			String str = entry.getKey().getName();
			if(str.endsWith("Future"))
				oo = ((Future) entry.getKey()).getBuyDate().toString();
			Object[] obj = { entry.getKey().getName(), String.valueOf(entry.getKey().getBuyTimePrice()),
					String.valueOf(entry.getValue()), oo };
			//System.out.println(str);
			((DefaultTableModel) sdf.getTable().getModel()).addRow(obj);
		}
		sdf.getTable().updateUI();
	}
}
