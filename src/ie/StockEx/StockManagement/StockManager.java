package ie.StockEx.StockManagement;

public class StockManager {

	private static StockManager INSTANCE;
	
	private int productID;
	
	private StockManager() {
		this.productID = 0;
	}
	
	synchronized int getNextProductID() {
		productID++;
		
		return productID;
	}
	
	static StockManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StockManager();
		}
		
		return INSTANCE;
	}
}
