package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;  
import java.io.FileReader;



public class TraderDAOImpl implements TraderDAO{
	
	boolean loginverified = false;
	
	// login verified
	public boolean login(String id, String password) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/Trader.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(",");
				
				String last = item[item.length-1];
				if(id.equals(item[0]))
				{
					
					if(password.equals(item[2]))
					{
						loginverified = true;
						
						//System.out.println("Login successfully");
						
						break;
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginverified;
	}
	
	
	// select TNAME by TID
	
public String selectTnamebyTID(String TID) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/Trader.csv"));//换成你的文件名
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


