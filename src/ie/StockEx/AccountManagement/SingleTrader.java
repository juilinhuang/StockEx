package ie.StockEx.AccountManagement;

import java.time.LocalDateTime;

public class SingleTrader extends Trader implements IBuyPremium {
	
	private LocalDateTime premiumExpiryDate;
	
	SingleTrader(Depot depot, int id) {
		super(depot, id);
		
		state = new FreeState();
	}

	@Override
	public void buyPremiumYearly(String creditCard) {		
		state = new PremiumState();
		LocalDateTime today = LocalDateTime.now();
		premiumExpiryDate = today.plusYears(1);
	}

	@Override
	public void checkPremiumStatus() {
		if (premiumExpiryDate.isBefore(LocalDateTime.now())) {
			state = new FreeState();
		}
	}
}
