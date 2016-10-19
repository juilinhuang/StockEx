package ie.StockEx.AccountManagement;

public class AccountManager {

	private static AccountManager INSTANCE;
	
	private int traderID;
	
	private int depotID;
	
	private AccountManager() {
		traderID = 42; //TODO get from database
		depotID = 0;
	}
	
	public AccountManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AccountManager();
		}
		
		return INSTANCE;
	}
	
	public Trader loginTrader(String username, String password) throws IllegalArgumentException {
		if (username == null) {
			throw new IllegalArgumentException("the given username is null.");
		}
		if (password == null) {
			throw new IllegalArgumentException("the given password is null");
		}
		
		Trader trader = null;

		//TODO call database
		
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
