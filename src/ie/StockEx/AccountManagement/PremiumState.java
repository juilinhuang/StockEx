package ie.StockEx.AccountManagement;

class PremiumState extends TraderState {

	@Override
	int getTradesLimit() {
		return Integer.MAX_VALUE;
	}

	@Override
	float getInterestRate() {
		return 5.0f;
	}

	@Override
	float getCommissionRate() {
		return 1.5f;
	}

}
