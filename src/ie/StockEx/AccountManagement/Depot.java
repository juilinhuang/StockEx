package ie.StockEx.AccountManagement;

import java.util.ArrayList;
import java.util.Collection;

import ie.StockEx.StockManagement.FinancialProduct;

public abstract class Depot {

	private final int id;
	
	private double balance;
	
	private double currentValue;
	
	private Collection<FinancialProduct> assets;
	
	Depot(int id) {
		this.id = id;
		this.balance = 0.0d;
		this.currentValue = 0.0d;
		this.assets = new ArrayList<FinancialProduct>();
	}
	
	public int getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	public Collection<FinancialProduct> getAssets() {
		return assets;
	}
	
	void addAsset(FinancialProduct asset) {
		assert asset != null : "asset is not initialized";
		
		assets.add(asset);
	}
	
	void calculateDepotValue() {
		currentValue = 0.0d;
		
		for (FinancialProduct asset : assets) {
			currentValue += asset.calculateCurrentValue();
		}
	}
}
