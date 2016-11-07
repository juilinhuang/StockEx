package ie.StockEx.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.StockEx.AccountManagement.AccountManager;
import ie.StockEx.AccountManagement.Trader;

public class LoginTest {

	@Test
	public void test() {
		AccountManager am = AccountManager.getInstance();
		Trader trader = am.loginTrader("asd", "asd");
		assertEquals(11111116, trader.getId());
	}

}
