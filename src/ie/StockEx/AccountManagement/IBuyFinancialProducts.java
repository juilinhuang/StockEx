package ie.StockEx.AccountManagement;

import java.util.Date;

import ie.StockEx.StockManagement.Stock;

public interface IBuyFinancialProducts {

	public void buyStock(Stock stock) throws OutOfTradesException;
	
	public void buyFuture(Stock stock, Date date, int quantity) throws OutOfTradesException;

	public void sellStock(Stock stock, int quantity);
}
