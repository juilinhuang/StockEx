package ie.StockEx.AccountManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import ie.StockEx.StockManagement.IFinancialProduct;

public abstract class Depot extends Observable {

	private final int id;

	protected double balance;

	protected double currentValue;

	protected Map<IFinancialProduct, Integer> assets;

	Depot(int id) {
		this.id = id;
		this.balance = 0.0d;
		this.currentValue = 0.0d;
		this.assets = new HashMap<IFinancialProduct, Integer>();
	}

	Depot(int id, double balance, double currentValue, Map<IFinancialProduct, Integer> assets) {
		this.id = id;
		this.balance = balance;
		this.currentValue = currentValue;
		this.assets = assets;
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

		balance -= asset.getBuyTimePrice() * quantity;
		if (assets.containsKey(asset)) {
			quantity += assets.get(asset);
		}
		assets.put(asset, quantity);
		notifyObservers();
	}

	void sellAsset(IFinancialProduct asset, int quantity, TraderState state) {
		assert assets.containsKey(asset) : "asset does not belong to this depot.";
		
		asset.calculateCurrentValue();
		balance += (asset.getCurrentValue() * quantity) * (1 - state.getCommissionRate());
		int amount = assets.get(asset);
		amount -= quantity;
		if (amount == 0) {
			assets.remove(asset);
		} else {
			assets.put(asset, amount);
		}		
		notifyObservers();
	}

	void calculateDepotValue() {
		currentValue = 0.0d;

		for (IFinancialProduct asset : assets.keySet()) {
			asset.calculateCurrentValue();
			currentValue += asset.getCurrentValue() * assets.get(asset);
		}

		notifyObservers();
	}
}
