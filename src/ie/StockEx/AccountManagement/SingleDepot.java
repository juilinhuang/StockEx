package ie.StockEx.AccountManagement;

import java.util.Map;

import ie.StockEx.StockManagement.IFinancialProduct;

public class SingleDepot extends Depot {
	
	private SingleTrader owner;

	SingleDepot(int id) {
		super(id);
	}
	
	public static SingleDepot createSingleDepot(int id, double balance, double currentValue, Map<IFinancialProduct, Integer> assets) {
		SingleDepot depot = new SingleDepot(id);
		depot.balance = balance;
		depot.currentValue = currentValue;
		depot.assets = assets;
		
		return depot;
	}
	
	public Trader getOwner() {
		return owner;
	}
	
	void setOwner(SingleTrader owner) {
		assert owner != null : "owner is not initialized";
		
		this.owner = owner;
	}

}
