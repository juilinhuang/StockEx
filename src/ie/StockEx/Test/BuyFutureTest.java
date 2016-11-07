package ie.StockEx.Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.AccountManagement.OutOfTradesException;
import ie.StockEx.AccountManagement.Trader;
import ie.StockEx.StockExchangeConnection.XetraConnector;
import ie.StockEx.StockManagement.Stock;

public class BuyFutureTest {

	@Test
	public void test() throws OutOfTradesException {
		AccountManager am = AccountManager.getInstance();
		Trader trader = am.loginTrader("asd", "asd");
		Stock s = new Stock("Youtube", 60.33, 600012, new XetraConnector());
		Date date = new Date();
		date.setYear(2017);
		trader.buyFuture(s, date, 3);
		assertEquals(4, trader.getDepot().getAssets().size());
	}

}
