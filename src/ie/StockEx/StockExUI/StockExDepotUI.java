package ie.StockEx.StockExUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class StockExDepotUI extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;
	private JButton mainButton;
	private JButton payPremiumButton;
	private JPanel panel;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public StockExDepotUI() {
		setTitle("StockEx-My Depot");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
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

		// -------------------------------------------------
		String[] columns = { "Stock", "Price", "Amount" };

		String[][] data = { { "Youtube", "60.33", "1" }, { "Amazon", "53.22", "3" }, { "Google", "73.89", "5" },
				{ "Intel", "28.65", "2" }, { "Microsoft", "30.32", "2" } };

		table = new JTable(data, columns) {
			/**
			 * 
			 */
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

				return c;
			}
		};
		table.setCellSelectionEnabled(true);

		table.setPreferredScrollableViewportSize(new Dimension(280, 280));
		table.setFillsViewportHeight(true);

		JScrollPane jps = new JScrollPane(table);
		jps.setBounds(0, 0, 300, 310);
		// --------------------------------------------------
		tablePanel.add(jps);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(326, 34, 248, 316);
		contentPane.add(verticalBox);

		panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(10, 118, 228, 187);
		panel.add(verticalBox_1);

		JPanel panel_1 = new JPanel();
		verticalBox_1.add(panel_1);
		panel_1.setLayout(null);

		JButton addBalanceButton = new JButton("Add Balance");
		addBalanceButton.setBounds(47, 71, 139, 23);
		panel_1.add(addBalanceButton);

		payPremiumButton = new JButton("Pay Premium");
		payPremiumButton.setBounds(47, 105, 139, 23);
		panel_1.add(payPremiumButton);

		JButton withdrawButton = new JButton("Withdraw Money");
		withdrawButton.setBounds(47, 139, 139, 23);
		panel_1.add(withdrawButton);

		JLabel lblBalance = new JLabel("Balance: ");
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setBounds(40, 21, 74, 14);
		panel_1.add(lblBalance);

		JLabel lblDepotValue = new JLabel("Depot Value: ");
		lblDepotValue.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepotValue.setBounds(40, 46, 74, 14);
		panel_1.add(lblDepotValue);

		JLabel balanceLabel = new JLabel("120,000");
		balanceLabel.setToolTipText("");
		balanceLabel.setBounds(124, 21, 59, 14);
		panel_1.add(balanceLabel);

		JLabel depotValueLabel = new JLabel("36,567.66");
		depotValueLabel.setBounds(124, 46, 59, 14);
		panel_1.add(depotValueLabel);

		JSpinner amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		amountSpinner.setBounds(114, 58, 57, 20);
		panel.add(amountSpinner);

		JLabel lblAmount = new JLabel("Amount: ");
		lblAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmount.setBounds(47, 61, 57, 14);
		panel.add(lblAmount);

		JLabel lblSelect = new JLabel("Select: ");
		lblSelect.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSelect.setBounds(47, 11, 57, 14);
		panel.add(lblSelect);

		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(47, 36, 57, 14);
		panel.add(lblPrice);

		JLabel stockLabel = new JLabel("");
		stockLabel.setBounds(114, 11, 57, 14);
		panel.add(stockLabel);

		JLabel priceLabel = new JLabel("");
		priceLabel.setBounds(114, 36, 57, 14);
		panel.add(priceLabel);

		JButton btnSellStock = new JButton("Sell Stock");
		btnSellStock.setBounds(57, 89, 139, 23);
		panel.add(btnSellStock);

		mainButton = new JButton("Main");
		mainButton.setBounds(396, 0, 89, 23);
		contentPane.add(mainButton);
	}

	// ............................................................................
	public void addLogoutButtonListener(ActionListener inLis) {
		logoutButton.addActionListener(inLis);
	}
	// ............................................................................

	public void addMainButtonListener(ActionListener inLis) {
		mainButton.addActionListener(inLis);
	}

	public void addPayPremiumButtonListener(ActionListener inLis) {
		payPremiumButton.addActionListener(inLis);
	}
}