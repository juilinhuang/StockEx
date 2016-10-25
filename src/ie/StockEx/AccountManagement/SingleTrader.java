package ie.StockEx.AccountManagement;

import java.time.LocalDateTime;

import ie.StockEx.PaymentManagement.CreditCard;

public class SingleTrader extends Trader implements IBuyPremium {

	private LocalDateTime premiumExpiryDate;

	SingleTrader(Depot depot, int id) {
		super(depot, id);

		// initialize with the free trader state
		state = new FreeState();
	}

	@Override
	public boolean buyPremiumYearly(String creditCard) {
		// get new transaction connector and make yearly payment
		CreditCard paymentConnector = new CreditCard(creditCard);
		boolean result = paymentConnector.makePayment(100.0d);

		if (result) {
			// change to premium state
			state = new PremiumState();
			LocalDateTime today = LocalDateTime.now();
			premiumExpiryDate = today.plusYears(1);
		}

		return result;
	}

	@Override
	public void checkPremiumStatus() {
		if (premiumExpiryDate.isBefore(LocalDateTime.now())) {
			state = new FreeState();
		}
	}
}
