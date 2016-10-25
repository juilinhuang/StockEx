package ie.StockEx.AccountManagement;

public abstract class TraderFactory {
	
	protected final UniqueIdManager idManager;
	
	public TraderFactory() {
		this.idManager = UniqueIdManager.getInstance();
	}

	abstract Trader createNewTrader();
	
	public abstract Trader createNewTrader(Depot depot, int id);
}
