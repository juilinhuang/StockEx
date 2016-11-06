package ie.StockEx.AccountManagement;

class FreeState extends TraderState {

	@Override
	int getTradesLimit() {
		return 10;
	}

	@Override
	float getInterestRate() {
		return 0.1f;
	}

	@Override
	float getCommissionRate() {
		return 0.03f;
	}

}
