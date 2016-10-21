package ie.StockEx.DatabaseConnection;

import ie.StockEx.AccountManagement.Trader;

public abstract class DataBaseConnector {
	
	public abstract Trader getTrader(String username, String password);
}
