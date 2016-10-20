package ie.StockEx.DatabaseConnection;

import java.io.IOException;
import java.util.ArrayList;

public interface StockDAO {
	
	// Please notify output better when you invoke selectAllStock method
	/* * for(int j=0;j<lineList.size();)
        	{
        		for(int i=0;i<COLUMN_NUM;i++)   // column_num should be 3
        			{
        				System.out.print(lineList.get(j)+" ");
        				j++;
        			}
        		System.out.println();
        	}    */
	public abstract ArrayList<String> selectAllStock() throws IOException; 
	
	public abstract String[] selectStockBySID(String SID);

}
