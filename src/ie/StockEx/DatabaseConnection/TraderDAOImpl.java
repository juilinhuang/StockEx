package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;  
import java.io.FileReader;



public class TraderDAOImpl implements TraderDAO{
	
	String loginverified = "This ID is not exist";
	String ID;
	String Password;
	// login verified
	public TraderDAOImpl login(String id, String password) {
		
		TraderDAOImpl trader = new TraderDAOImpl();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("../StockTrader/Trader.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(",");
				
				String last = item[item.length-1];
				if(id.equals(item[0]))
				{
					
					if(password.equals(item[2]))
					{
						//loginverified = "login successfully";
						trader.ID = item[0];
						trader.Password = item[2];
						//System.out.println(trader.ID);
						break;
						
						
					}
					else
						trader = null;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trader;
	}
	
	
	// select TNAME by TID
	
public String selectTnamebyTID(String TID) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("../StockTrader/Trader.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(",");
				
				String last = item[item.length-1];
				if(TID.equals(item[0]))
				{
					System.out.print(item[1]);
					return item[1];
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "This ID is not exist";
	}
	
			
}


