package ie.StockEx.StockManagement;

import java.util.Observable;
import java.util.Observer;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;

public abstract class FinancialProduct extends Observable implements IFinancialProduct, Observer {

	private final double buyTimePrice;
	
	private double currentValue;
	
	private String name;
	
	private int id;
	
	protected StockExchangeConnector exchangeConnector;
	
	FinancialProduct(String name, int id, double buyTimePrice, StockExchangeConnector exchangeConnector) {
		this.name = name;
		this.id = id;
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
