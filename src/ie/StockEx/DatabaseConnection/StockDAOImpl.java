package ie.StockEx.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StockDAOImpl implements StockDAO {
	
    public static final int COLUMN_NUM = 3;//number of columns in csv
    
    String SID;
    String Sname;
    String Svalue;
    
    @Override
	public  ArrayList<String> selectAllStock() throws IOException 
	{
        BufferedReader br = new BufferedReader(new FileReader("../StockTrader/Stock.csv"));
        String line = "";
        ArrayList<String> lineList = new ArrayList<String>();
        
       // Read a single line from the file until there are no more lines to read
        while((line = br.readLine()) != null)
	        { 
	            StringTokenizer st = new StringTokenizer(line, ","); //comma as separator
	           
	            for(int i = 0; i < COLUMN_NUM; i++) 
	            { // For each token in the line that we've read:
	                
	                if(st.hasMoreTokens())
	                {
	                	lineList.add(st.nextToken());
	                }
	            
	            }
	        }
        
     /* 	for(int j1=0;j1<lineList.size();)
        	{
        		for(int i1=0;i1<COLUMN_NUM;i1++)
        			{
        				System.out.print(lineList.get(j1)+" ");
        				j1++;
        			}
        		System.out.println();
        	}
       */
       br.close();
       
       return lineList;
	}

	@Override
	public StockDAOImpl selectStockBySID(String SID) {
		
		StockDAOImpl stock = new StockDAOImpl();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("../StockTrader/Stock.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(",");
				
				String last = item[item.length-1];
				if(SID.equals(item[0]))
				{
					stock.SID = item[0];
					stock.Sname = item[1];
					stock.Svalue = item[2];
					//for(int i=0;i<item.length;i++)
					//System.out.print(item[i]+" ");
					return stock;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 

}
