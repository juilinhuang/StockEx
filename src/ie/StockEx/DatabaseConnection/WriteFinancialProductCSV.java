package ie.StockEx.DatabaseConnection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFinancialProductCSV extends DataBaseConnector {
	public void Initial() throws IOException 
	{
	try { 
		File csv = new File("C:/Users/Administrator/Desktop/FinancialProduct.csv"); 
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		bw.newLine(); 
		bw.write("FID" + "," + "FNAME" + "," + "VALUE"); 
		bw.write("\r\n");
		bw.write("600012" + "," + "Youtube" + "," + "60.33"); 
		bw.write("\r\n");		
		bw.write("600034" + "," + "Amazon" + "," + "53.22"); 
		bw.write("\r\n");		
		bw.write("600056" + "," + "Google" + "," + "73.89"); 
		bw.write("\r\n");		
		bw.write("600078" + "," + "Intel" + "," + "28.65"); 
		bw.write("\r\n");		
		bw.write("600090" + "," + "Microsoft" + "," + "30.32"); 
		bw.close(); 
		//System.out.println("Financial Product Table Initialed");
		} 
	catch (FileNotFoundException e) 
		{ 
		e.printStackTrace(); 
		} 
	catch (IOException e) 
		{ 
		e.printStackTrace(); 
		}
	}
}