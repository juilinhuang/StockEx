package ie.StockEx.StockManagement;

import java.util.HashMap;
import java.util.Map;

public class StockManager {

	private static StockManager INSTANCE;
	
	private int productID;
	
	private Map<String, Stock> stocks;
	
	private StockManager() {
		this.productID = 0;
		this.stocks = new HashMap<String, Stock>();
	}
	
	synchronized int getNextProductID() {
		productID++;
		
		return productID;
	}
	
	public Stock getStock(String name) {
		if (name == null) {
			throw new IllegalArgumentException("the given name is not initialized");
		}
		
		Stock result = stocks.get(name);
		if (result == null) {
			
		}
		
		return result;
	}
	
	static StockManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StockManager();
		}
		
		return INSTANCE;
	}
}
