package ie.StockEx.AccountManagement;

import java.util.Date;

import ie.StockEx.StockManagement.Stock;

public interface IBuyFinancialProducts {

	public void buyStock(Stock stock) throws OutOfTradesException;
	
	public void buyFuture(Stock stock, Date date) throws OutOfTradesException;
}