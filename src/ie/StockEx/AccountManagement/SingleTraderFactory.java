package ie.StockEx.AccountManagement;

public class SingleTraderFactory extends TraderFactory {

	public SingleTraderFactory(AccountManager manager) {
		super(manager);
	}

	@Override
	Trader createNewTrader() {
		SingleDepot depot = new SingleDepot(manager.getNextDepotID());
		SingleTrader trader = new SingleTrader(depot, manager.getNextTraderID());
		depot.setOwner(trader);
		//TODO write to database manager.xy
		
		return trader;
	}

}
