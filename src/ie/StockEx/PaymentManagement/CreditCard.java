package ie.StockEx.PaymentManagement;

public class CreditCard extends PaymentTransactor {
	int accountnumber = 00000000;
	
	
	public CreditCard() {
		accountnumber++;
	}
	
	public CreditCard(int number)
	{
		accountnumber = number;
		
	}

		@Override
		boolean makePayment(double amount) {
			
			int a = (int)(Math.random()*100);
			
			return a > 20;
		}
		
	
}
