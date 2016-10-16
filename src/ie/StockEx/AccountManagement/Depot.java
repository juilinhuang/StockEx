package ie.StockEx.AccountManagement;

import java.util.HashMap;
import java.util.Map;

import ie.StockEx.StockManagement.IFinancialProduct;

public abstract class Depot {

	private final int id;
	
	private double balance;
	
	private double currentValue;
	
	private Map<IFinancialProduct, Integer> assets;
	
	Depot(int id) {
		this.id = id;
		this.balance = 0.0d;
		this.currentValue = 0.0d;
		this.assets = new HashMap<IFinancialProduct, Integer>();
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
	
	public Map<IFinancialProduct, Integer> getAssets() {
		return assets;
	}
	
	void addAsset(IFinancialProduct asset, int quantity) {
		assert asset != null : "asset is not initialized";
		
		assets.put(asset, quantity);
	}
	
	void calculateDepotValue() {
		currentValue = 0.0d;
		
		for (IFinancialProduct asset : assets.keySet()) {
			asset.calculateCurrentValue();
			currentValue += asset.getCurrentValue();
		}
	}
}
