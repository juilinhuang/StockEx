package ie.StockEx.AccountManagement;

public abstract class TraderFactory {
	
	protected final AccountManager manager;
	
	public TraderFactory(AccountManager manager) {
		this.manager = manager;
	}

	abstract Trader createNewTrader();
	
	public abstract Trader createNewTrader(Depot depot, int id);
}
