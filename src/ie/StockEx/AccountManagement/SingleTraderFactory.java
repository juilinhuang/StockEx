package ie.StockEx.AccountManagement;

public class SingleTraderFactory extends TraderFactory {

	Trader createNewTrader() {
		SingleDepot depot = new SingleDepot(idManager.getNextDepotId());
		SingleTrader trader = new SingleTrader(depot, idManager.getNextTraderId());
		depot.setOwner(trader);

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
