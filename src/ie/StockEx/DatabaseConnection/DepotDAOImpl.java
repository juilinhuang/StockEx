package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DepotDAOImpl implements DepotDAO {
	
	String DID = null;
	String Balance = null;
	String OpenDate = null;

	
	@Override
	
		public DepotDAOImpl selectDepotByDID(String id) {
			
			DepotDAOImpl depot = new DepotDAOImpl();
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader("../StockTrader/Depot.csv"));//换成你的文件名
				reader.readLine();
				String line = null;
				while((line=reader.readLine())!=null){
					String item[] = line.split(",");
					
					String last = item[item.length-1];
					if(id.equals(item[0]))
					{
						depot.DID = item[0];
						depot.Balance = item[1];
						depot.OpenDate = item[2];
						//for(int i=0;i<item.length;i++)
						//System.out.print(item[i]+" ");
						return depot;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return depot;
		} 

	
}
