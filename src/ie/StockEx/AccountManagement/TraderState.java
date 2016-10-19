package ie.StockEx.AccountManagement;

abstract class TraderState {

	abstract int getTradesLimit();
	
	abstract float getInterestRate();
	
	abstract float getCommissionRate();
}
