package ie.StockEx.AccountManagement;

import ie.StockEx.DatabaseConnection.DataBaseConnector;
import ie.StockEx.DatabaseConnection.FileDatabaseConnector;

public class AccountManager {

	private static AccountManager INSTANCE;

	private final DataBaseConnector database;

	private AccountManager() {
		this.database = new FileDatabaseConnector();
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

		// query trader from the database
		Trader trader = database.getTrader(username, password);

		return trader;
	}

}
