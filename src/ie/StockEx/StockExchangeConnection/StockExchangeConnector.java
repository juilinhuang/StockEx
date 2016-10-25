package ie.StockEx.StockExchangeConnection;

import java.util.Observable;

public abstract class StockExchangeConnector extends Observable implements Runnable{

	public abstract double getCurrentPriceForStock(int stockId);
}
