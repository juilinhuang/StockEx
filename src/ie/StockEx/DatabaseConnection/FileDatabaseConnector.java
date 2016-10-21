package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import ie.StockEx.AccountManagement.*;
import ie.StockEx.AccountManagement.SingleDepot;
import ie.StockEx.AccountManagement.SingleTraderFactory;
import ie.StockEx.StockManagement.IFinancialProduct;


public class FileDatabaseConnector extends DataBaseConnector {
	
	int did;
	int tid;
	String tpassword;
	double balance;
	Map<IFinancialProduct, Integer> assets;
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
					//System.out.println(did+" "+balance+" "+currentValue);
				}
			}
			
			
			//SingleTraderFactory trader = SingleTraderFactory.
			//SingleFactory
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AccountManager accountmanager = AccountManager.getInstance();			
		SingleDepot depot = SingleDepot.createSingleDepot(did, balance, currentValue, assets);
		SingleTraderFactory factory = new SingleTraderFactory(AccountManager.getInstance());
		Trader trader = factory.createNewTrader(depot, tid);
		
		//System.out.println(loginverified);
		
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
