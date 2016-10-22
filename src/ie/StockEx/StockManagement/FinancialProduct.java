package ie.StockEx.StockManagement;

import java.util.Observable;
import java.util.Observer;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public abstract class FinancialProduct extends Observable implements IFinancialProduct, Observer {

	private final double buyTimePrice;
	
	protected double currentValue;
	
	private final String name;
	
	private final int id;
	
	protected StockExchangeConnector exchangeConnector;
	
	FinancialProduct(String name, double buyTimePrice, StockExchangeConnector exchangeConnector) {
		this.name = name;
		this.id = StockManager.getInstance().getNextProductID();
		this.buyTimePrice = buyTimePrice;
		this.exchangeConnector = exchangeConnector;
	}
	
	@Override
	public double getBuyTimePrice() {
		return buyTimePrice;
	}
	
	@Override
	public double getCurrentValue() {
		return currentValue;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	protected abstract void updateCurrentValue();
	
	@Override
	public void calculateCurrentValue() {
		updateCurrentValue();
		notifyObservers(this);
	}
	
	int getId() {
		return id;
	}
	
}
