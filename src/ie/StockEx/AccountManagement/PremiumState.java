package ie.StockEx.AccountManagement;

class PremiumState extends TraderState {

	@Override
	int getTradesLimit() {
		return Integer.MAX_VALUE;
	}

	@Override
	float getInterestRate() {
		return 0.05f;
	}

	@Override
	float getCommissionRate() {
		return 0.15f;
	}

}
