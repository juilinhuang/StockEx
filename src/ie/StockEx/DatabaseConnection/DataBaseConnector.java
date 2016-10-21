package ie.StockEx.DatabaseConnection;

import ie.StockEx.AccountManagement.Trader;

public abstract class DataBaseConnector {
	
	public abstract Trader getTraderById(int id);
}
