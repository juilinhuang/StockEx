package ie.StockEx.StockManagement;

import java.util.Date;
import java.util.Observable;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public class Future extends FinancialProduct {

	private final Stock stock;

	private final Date buyDate;

	public Future(String name, double buyTimePrice, StockExchangeConnector exchangeConnector, Stock stock, Date date) {
		super(name, buyTimePrice, exchangeConnector);

		this.stock = stock;
		this.buyDate = date;
	}

	public Stock getStock() {
		return stock;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		calculateCurrentValue();
	}

	@Override
	protected void updateCurrentValue() {
		stock.updateCurrentValue();
		currentValue = stock.currentValue;
	}

}
