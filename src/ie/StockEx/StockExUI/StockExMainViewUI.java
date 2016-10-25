package ie.StockEx.StockExUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;

public class StockExMainViewUI extends JFrame {

	private JPanel contentPane;
	private JButton logoutButton;
	private JButton depotButton;
	private JTable table;
	private JPanel panel;
	private JLabel StockLabel;
	private JLabel priceLabel;
	private JSpinner amountSpinner;
	private JButton buyStockButton;
	private JButton buyFutureButton;
	private JButton buyCFDButton;

	/**
	 * Create the frame.
	 */
	public StockExMainViewUI() {
		setTitle("StockEX-Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		String[] columns = { "Stock", "Price" };

		String[][] data = { { "Youtube", "60.33" }, { "Amazon", "53.22" }, { "Google", "73.89" }, { "Intel", "28.65" },
				{ "Microsoft", "30.32" } };

		table = new JTable(data, columns) {

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
		table.changeSelection(0, 0, false, false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setPreferredScrollableViewportSize(new Dimension(280, 280));
		table.setFillsViewportHeight(true);

		JScrollPane jps = new JScrollPane(table);
		jps.setBounds(0, 0, 300, 310);
		tablePanel.add(jps);
		// --------------------------------------------------

		panel = new JPanel();
		panel.setBounds(326, 34, 248, 316);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(61, 47, 57, 14);
		panel.add(lblName);

		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(61, 72, 57, 14);
		panel.add(lblPrice);

		JLabel lblAmount = new JLabel("Amount: ");
		lblAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmount.setBounds(61, 97, 57, 14);
		panel.add(lblAmount);

		StockLabel = new JLabel("sssss");
		StockLabel.setBounds(128, 47, 57, 14);
		panel.add(StockLabel);

		priceLabel = new JLabel("12.50");
		priceLabel.setBounds(128, 72, 57, 14);
		panel.add(priceLabel);

		amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));// TODO get amount from depot
		amountSpinner.setBounds(128, 94, 57, 20);
		panel.add(amountSpinner);

		buyStockButton = new JButton("Buy Stock");
		buyStockButton.setBounds(75, 142, 99, 23);
		panel.add(buyStockButton);

		buyFutureButton = new JButton("Buy Future");
		buyFutureButton.setBounds(75, 176, 99, 23);
		panel.add(buyFutureButton);

		buyCFDButton = new JButton("Buy CFD");
		buyCFDButton.setBounds(75, 210, 99, 23);
		panel.add(buyCFDButton);

		depotButton = new JButton("My Depot");
		depotButton.setBounds(75, 244, 99, 23);
		panel.add(depotButton);
	}

	// ..........................................................................
	public void addLogoutButtonListener(ActionListener inLis) {
		logoutButton.addActionListener(inLis);
	}
	// ..........................................................................

	public void addDepotButtonListener(ActionListener inLis) {
		depotButton.addActionListener(inLis);
	}
}
