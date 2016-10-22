package ie.StockEx.StockManagement;

import java.util.Observable;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public class Future extends FinancialProduct {
	
	private final Stock stock;

	Future(String name, int id, double buyTimePrice, StockExchangeConnector exchangeConnector, Stock stock) {
		super(name, id, buyTimePrice, exchangeConnector);
		
		this.stock = stock;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Integer && (int)arg1 == stock.getId()) {
			calculateCurrentValue();
		}
	}

	@Override
	protected void updateCurrentValue() {
		exchangeConnector.getCurrentPriceForStock(stock.getStockId());
	}

}
