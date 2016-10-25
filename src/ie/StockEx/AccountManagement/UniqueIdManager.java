package ie.StockEx.AccountManagement;

import ie.StockEx.DatabaseConnection.DataBaseConnector;

class UniqueIdManager {

	private static UniqueIdManager INSTANCE;

	private int traderID;

	private int depotID;

	@SuppressWarnings("unused")
	private final DataBaseConnector database;

	private UniqueIdManager() {
		this.database = null; // replace by actual database connector
	}

	static UniqueIdManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UniqueIdManager();
		}

		return INSTANCE;
	}

	int getNextTraderId() {
		traderID++;

		return traderID;
	}

	int getNextDepotId() {
		depotID++;

		return depotID;
	}
}
