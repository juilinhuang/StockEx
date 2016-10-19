package ie.StockEx.AccountManagement;

public class SingleTrader extends Trader {
	
	private TraderState state;

	SingleTrader(Depot depot, int id) {
		super(depot, id);
		
		state = new FreeState();
	}

}
