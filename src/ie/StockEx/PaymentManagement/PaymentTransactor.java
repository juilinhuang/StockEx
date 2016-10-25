package ie.StockEx.PaymentManagement;


public abstract class PaymentTransactor {

	abstract boolean makePayment(double amount);
}
