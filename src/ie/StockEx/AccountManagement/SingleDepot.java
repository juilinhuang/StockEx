package ie.StockEx.AccountManagement;

public class SingleDepot extends Depot {
	
	private SingleTrader owner;

	SingleDepot(int id) {
		super(id);
	}
	
	public Trader getOwner() {
		return owner;
	}
	
	void setOwner(SingleTrader owner) {
		this.owner = owner;
	}

}
