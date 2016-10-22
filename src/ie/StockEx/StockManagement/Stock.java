package ie.StockEx.StockManagement;

import java.util.Observable;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public class Stock extends FinancialProduct {
	
	private final int stockId;

	public Stock(String name, double buyTimePrice, int stockId, StockExchangeConnector exchangeConnector) {
		super(name, buyTimePrice, exchangeConnector);
		this.stockId = stockId;
	}
	
	public int getStockId() {
		return stockId;
	}

	@Override
	protected void updateCurrentValue() {
		currentValue = exchangeConnector.getCurrentPriceForStock(stockId);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Integer && (int)arg == stockId) {
			calculateCurrentValue();
		}		
	}

}
