package ie.StockEx.AccountManagement;

import java.util.Date;

import ie.StockEx.StockExchangeConnection.StockExchangeConnector;
import ie.StockEx.StockExchangeConnection.XetraConnector;
import ie.StockEx.StockManagement.Future;
import ie.StockEx.StockManagement.Stock;

public abstract class Trader implements IBuyFinancialProducts {
	
	protected final Depot depot;
	
	private final int id;
	
	protected TraderState state;
	
	protected int tradesThisDay;
	
	Trader(Depot depot, int id) {
		this.depot = depot;
		this.id = id;
		this.tradesThisDay = 0;
	}
	
	public Depot getDepot() {
		return depot;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public void buyStock(Stock stock) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void buyFuture(Stock stock, Date date) throws OutOfTradesException {
		if (tradesThisDay > state.getTradesLimit()) {
			throw new OutOfTradesException();
		}
		
		StockExchangeConnector connector = new XetraConnector();
		Future future = new Future(stock.getName() + "_Future", stock.getBuyTimePrice(), connector, stock, date);;
	
		depot.addAsset(future, 1);
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
