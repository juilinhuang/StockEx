package ie.StockEx.StockManagement;

import java.util.Observable;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public class Stock extends FinancialProduct {
	
	private final int stockId;

	public Stock(String name, int id, double buyTimePrice, int stockId, StockExchangeConnector exchangeConnector) {
		super(name, id, buyTimePrice, exchangeConnector);
		this.stockId = stockId;
	}

	@Override
	protected void updateCurrentValue() {
		exchangeConnector.getCurrentPriceForStock(stockId);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Integer && (int)arg == stockId) {
			calculateCurrentValue();
		}		
	}

}
