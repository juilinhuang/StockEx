package ie.StockEx.StockExchangeConnection;

public abstract class StockExchangeConnector extends Thread {

	public abstract double getCurrentPriceForStock(int stockId);
}
