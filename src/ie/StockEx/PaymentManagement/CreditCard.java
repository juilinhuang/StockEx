package ie.StockEx.PaymentManagement;

public class CreditCard extends PaymentTransactor {

	private String cardNumber;

	public CreditCard(String number) {
		cardNumber = number;

	}

	@Override
	public boolean makePayment(double amount) {

		int a = (int) (Math.random() * 100);

		return a > 20;
	}

}
