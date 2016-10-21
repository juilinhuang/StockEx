package ie.StockEx.AccountManagement;

public class SingleTraderFactory extends TraderFactory {

	public SingleTraderFactory(AccountManager manager) {
		super(manager);
	}

	Trader createNewTrader() {
		SingleDepot depot = new SingleDepot(manager.getNextDepotID());
		SingleTrader trader = new SingleTrader(depot, manager.getNextTraderID());
		depot.setOwner(trader);
		// TODO write to database manager.xy

		return trader;
	}

	public Trader createNewTrader(Depot depot, int id) {
		if (!(depot instanceof SingleDepot)) {
			return null;
		}

		SingleTrader trader = new SingleTrader(depot, id);
		((SingleDepot) depot).setOwner(trader);

		return trader;
	}

}
