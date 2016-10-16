package ie.StockEx.StockExControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sun.javafx.event.EventQueue;

import ie.StockEx.StockExUI.StockExLogninUI;
import ie.StockEx.StockExUI.StockExMainViewUI;

public class StockExMainViewControl {

	private StockExMainViewUI mView;

	public StockExMainViewControl(StockExMainViewUI mv) {
		mView = mv;
		mView.addLogoutButtonListener(new LogoutListener());
	}

	class LogoutListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			StockExLogninUI slf = new StockExLogninUI();
			new StockExLoginControl(slf);
			slf.setVisible(true);
			mView.dispose();
		}
	}
	

}
