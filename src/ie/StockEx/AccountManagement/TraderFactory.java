package ie.StockEx.AccountManagement;

public abstract class TraderFactory {
	
	protected AccountManager manager;
	
	public TraderFactory(AccountManager manager) {
		this.manager = manager;
	}

	abstract Trader createNewTrader();
}
