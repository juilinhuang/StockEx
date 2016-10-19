package ie.StockEx.AccountManagement;

class FreeState extends TraderState {

	@Override
	int getTradesLimit() {
		return 10;
	}

	@Override
	float getInterestRate() {
		return 10.0f;
	}

	@Override
	float getCommissionRate() {
		return 3.0f;
	}

}
