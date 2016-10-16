package ie.StockEx.StockExchangeConnection;

public abstract class StockExchangeConnector {

	public abstract double getCurrentPriceForStock(int stockId);
}
