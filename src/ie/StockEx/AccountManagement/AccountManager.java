package ie.StockEx.AccountManagement;

import ie.StockEx.DatabaseConnection.DataBaseConnector;
import ie.StockEx.DatabaseConnection.FileDatabaseConnector;

public class AccountManager {

	private static AccountManager INSTANCE;

	private int traderID;

	private int depotID;

	private AccountManager() {
		traderID = 42; // TODO get from database
		depotID = 0;
	}

	public static AccountManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AccountManager();
		}

		return INSTANCE;
	}

	public Trader loginTrader(String username, String password) throws IllegalArgumentException {
		if (username.length() == 0) {
			throw new IllegalArgumentException("the given username is null.");
		}
		if (password.length() == 0) {
			throw new IllegalArgumentException("the given password is null.");
		}

		DataBaseConnector dbConnector = new FileDatabaseConnector();

		Trader trader = dbConnector.getTrader(username, password);

		return trader;
	}

	int getNextTraderID() {
		traderID++;

		return traderID;
	}

	int getNextDepotID() {
		depotID++;

		return depotID;
	}

}
