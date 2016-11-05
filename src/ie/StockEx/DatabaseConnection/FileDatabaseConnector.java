package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import ie.StockEx.AccountManagement.*;
import ie.StockEx.AccountManagement.SingleDepot;
import ie.StockEx.AccountManagement.SingleTraderFactory;
import ie.StockEx.StockExchangeConnection.StockExchangeConnector;
import ie.StockEx.StockExchangeConnection.XetraConnector;
import ie.StockEx.StockManagement.IFinancialProduct;
import ie.StockEx.StockManagement.Stock;


public class FileDatabaseConnector extends DataBaseConnector {
	
	int did;
	int tid;
	String tpassword;
	double balance;
	double currentValue;
	@Override
	public Trader getTrader(String username, String password) {
		boolean loginverified = false;

		
		try {
			
			BufferedReader reader1 = new BufferedReader(new FileReader("../StockTrader/Trader.csv"));
			reader1.readLine();
			String line1 = null;
			while((line1=reader1.readLine())!=null){
				String item1[] = line1.split(",");
				
				String last = item1[item1.length-1];
				
				//String str1 = String.valueOf(id);
				if(username.equals(item1[1]))
				{
					if(password.equals(item1[2]))
						{	
							tid = Integer.parseInt(item1[0]);
							tpassword = item1[2];
							did = Integer.parseInt(item1[3]);
							loginverified = true;
							break;			
						}
					
				}
				

				}
			
			
			BufferedReader reader = new BufferedReader(new FileReader("../StockTrader/Depot.csv"));
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(",");
				
				String last = item[item.length-1];
				
				String str = String.valueOf(did);
				
				if(str.equals(item[0]))
				{
					did = Integer.parseInt(item[0]);
					balance = Double.parseDouble(item[1]);
					currentValue = Double.parseDouble(item[2]);
				}
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		StockExchangeConnector exchangeConnector = new XetraConnector();
		Map<IFinancialProduct, Integer> assets = new HashMap<IFinancialProduct, Integer>();
		IFinancialProduct stock1 = new Stock("Youtube", 22.32, 600012, exchangeConnector);
		IFinancialProduct stock2 = new Stock("Amazon", 11.33, 600034, exchangeConnector);
		IFinancialProduct stock3 = new Stock("Google", 8.97, 600056, exchangeConnector);
		assets.put(stock1, 10);
		assets.put(stock2, 20);
		assets.put(stock3, 30);
		AccountManager accountmanager = AccountManager.getInstance();			
		SingleDepot depot = SingleDepot.createSingleDepot(did, balance, currentValue, assets);
		SingleTraderFactory factory = new SingleTraderFactory();
		Trader trader = factory.createNewTrader(depot, tid);
				
		if(loginverified == true)
			{
				return trader;
			}
		else
			{	
				return null;
			}
		
		
		
	}


}
