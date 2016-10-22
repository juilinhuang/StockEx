package ie.StockEx.StockManagement;

class StockManager {

	private static StockManager INSTANCE;
	
	private int productID;
	
	private StockManager() {
		this.productID = 0;
	}
	
	int getNextProductID() {
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
