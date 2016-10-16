package ie.StockEx.StockManagement;

public interface IFinancialProduct {

	public void calculateCurrentValue();
	
	public double getCurrentValue();
	
	public double getBuyTimePrice();
	
	public String getName();
}
