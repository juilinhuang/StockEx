package ie.StockEx.StockExUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import ie.StockEx.AccountManagement.Trader;
import ie.StockEx.StockManagement.Future;
import ie.StockEx.StockManagement.IFinancialProduct;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class StockExDepotUI extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;
	private JButton mainButton;
	private JButton buyPremiumButton;
	private JButton addBalanceButton;
	private JButton withdrawButton;
	private JButton sellStockButton;
	private JTable table;
	private JLabel stockLabel;
	private JLabel balanceLabel;
	private JLabel depotValueLabel;
	private JLabel priceLabel;
	private JSpinner amountSpinner;
	private Trader trader;

	/**
	 * Create the frame.
	 */
	public StockExDepotUI(Trader t) {
		trader = t;
		setTitle("StockEx-My Depot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		logoutButton = new JButton("Logout");
		logoutButton.setBounds(495, 0, 89, 23);
		contentPane.add(logoutButton);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(10, 34, 306, 316);
		contentPane.add(tablePanel);

		// -------------------------------------------------TODO change this
		// table
		// trader.getDepot().getAssets();
		// String[] columns = { "Stock", "Price", "Amount", "Date" };

		// String[][] data = { { "Youtube", "60.33", "1" ,""}, { "Amazon",
		// "53.22", "3", ""}, { "Google", "73.89", "5", "" },
		// { "Intel", "28.65", "2", "" }, { "Microsoft", "30.32", "2", "" } };

		table = new JTable() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int data, int columns) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
				Component c = super.prepareRenderer(r, data, columns);

				if (data % 2 == 0)
					c.setBackground(Color.WHITE);
				else
					c.setBackground(Color.LIGHT_GRAY);

				if (isRowSelected(data)) {
					c.setBackground(Color.CYAN);
				}
				return c;
			}
		};
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Stock", "Price", "Amount", "Date" }));
//		 Object[] obj1 = { "1", "2", "3", "4" };
//		 Object[] obj2 = { "11", "22", "33", "44" };
//		 Object[] obj3 = { "1236", "4569", "7892", "002" };
//		 ((DefaultTableModel) table.getModel()).addRow(obj1);
//		 ((DefaultTableModel) table.getModel()).addRow(obj2);
//		 ((DefaultTableModel) table.getModel()).addRow(obj3);

		
		for (Map.Entry<IFinancialProduct, Integer> entry : trader.getDepot().getAssets().entrySet()) {
			String oo = "";
			String str = entry.getKey().getName();
			if(str.endsWith("Future"))
				oo = ((Future) entry.getKey()).getBuyDate().toString();
			Object[] obj = { entry.getKey().getName(), String.valueOf(entry.getKey().getBuyTimePrice()),
					String.valueOf(entry.getValue()), oo };
			//System.out.println(str);
			((DefaultTableModel) table.getModel()).addRow(obj);
		}
		
//		for (Map.Entry<IFinancialProduct, Integer> entry : trader.getDepot().getAssets().entrySet()) {
//			Object[] obj = { entry.getKey().getName(), String.valueOf(entry.getKey().getBuyTimePrice()),
//					String.valueOf(entry.getValue()), ((Future) entry.getKey()).getBuyDate().toString() };
//			((DefaultTableModel) table.getModel()).addRow(obj);
//		}
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.changeSelection(0, 0, false, false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setPreferredScrollableViewportSize(new Dimension(280, 280));
		table.setFillsViewportHeight(true);

		JScrollPane jps = new JScrollPane(table);
		jps.setBounds(0, 0, 300, 310);
		tablePanel.add(jps);
		// --------------------------------------------------

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(326, 34, 248, 316);
		contentPane.add(verticalBox);

		JPanel leftPanel = new JPanel();
		verticalBox.add(leftPanel);
		leftPanel.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(10, 118, 228, 187);
		leftPanel.add(verticalBox_1);

		JPanel innerPanel = new JPanel();
		verticalBox_1.add(innerPanel);
		innerPanel.setLayout(null);

		mainButton = new JButton("Main");
		mainButton.setBounds(396, 0, 89, 23);
		contentPane.add(mainButton);

		addBalanceButton = new JButton("Add Balance");
		addBalanceButton.setBounds(47, 71, 139, 23);
		innerPanel.add(addBalanceButton);

		buyPremiumButton = new JButton("Buy Premium");
		buyPremiumButton.setBounds(47, 105, 139, 23);
		innerPanel.add(buyPremiumButton);

		withdrawButton = new JButton("Withdraw Money");
		withdrawButton.setBounds(47, 139, 139, 23);
		innerPanel.add(withdrawButton);

		sellStockButton = new JButton("Sell Stock");
		sellStockButton.setBounds(57, 89, 139, 23);
		leftPanel.add(sellStockButton);

		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setBounds(40, 21, 74, 14);
		innerPanel.add(lblBalance);

		JLabel lblDepotValue = new JLabel("Depot Value: ");
		lblDepotValue.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepotValue.setBounds(40, 46, 74, 14);
		innerPanel.add(lblDepotValue);

		balanceLabel = new JLabel(Double.toString(trader.getDepot().getBalance()));
		balanceLabel.setBounds(124, 21, 94, 14);
		innerPanel.add(balanceLabel);

		depotValueLabel = new JLabel(Double.toString(trader.getDepot().getCurrentValue()));
		depotValueLabel.setBounds(124, 46, 94, 14);
		innerPanel.add(depotValueLabel);

		amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		amountSpinner.setBounds(114, 58, 57, 20);
		leftPanel.add(amountSpinner);

		JLabel lblAmount = new JLabel("Amount: ");
		lblAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmount.setBounds(47, 61, 57, 14);
		leftPanel.add(lblAmount);

		JLabel lblSelect = new JLabel("Select: ");
		lblSelect.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSelect.setBounds(47, 11, 57, 14);
		leftPanel.add(lblSelect);

		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(47, 36, 57, 14);
		leftPanel.add(lblPrice);

		stockLabel = new JLabel("");
		try {
			stockLabel.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			// TODO make update
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		stockLabel.setBounds(114, 11, 57, 14);
		leftPanel.add(stockLabel);

		priceLabel = new JLabel("");
		try {
			priceLabel.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			// TODO make update
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		priceLabel.setBounds(114, 36, 57, 14);
		leftPanel.add(priceLabel);

	}

	// ............................................................................TODO
	// repeat code
	public void addLogoutButtonListener(ActionListener inLis) {
		logoutButton.addActionListener(inLis);
	}
	// ............................................................................

	public void addMainButtonListener(ActionListener inLis) {
		mainButton.addActionListener(inLis);
	}

	public void addBuyPremiumButtonListener(ActionListener inLis) {
		buyPremiumButton.addActionListener(inLis);
	}

	public void addsellStockButtonListener(ActionListener inLis) {
		sellStockButton.addActionListener(inLis);
	}

	public void addTableListener(ListSelectionListener inLis) {
		table.getSelectionModel().addListSelectionListener(inLis);
	}

	public JLabel getStockLabel() {
		return stockLabel;
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public JTable getTable() {
		return table;
	}

	public JLabel getBalanceLable() {
		return balanceLabel;
	}

	public JLabel getDepotValueLabelLable() {
		return depotValueLabel;
	}

	public JSpinner getAmountSpinner() {
		return amountSpinner;
	}
}
