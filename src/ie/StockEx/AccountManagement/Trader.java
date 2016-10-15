package ie.StockEx.AccountManagement;

public abstract class Trader {
	
	private final Depot depot;
	
	private final int id;
	
	public Trader(Depot depot, int id) {
		this.depot = depot;
		this.id = id;
	}
	
	public Depot getDepot() {
		return depot;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Trader) {
			result = id == ((Trader)obj).id;
		}
		
		return result;
	}
}
