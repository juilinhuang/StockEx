package ie.StockEx.DatabaseConnection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WritetTDCSV extends DataBaseConnector {
	public void Initial() throws IOException 
	{
	try { 
		File csv = new File("C:/Users/Administrator/Desktop/TD.csv"); 
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		bw.newLine(); 
		bw.write("TID" + "," + "DID"); 
		bw.write("\r\n");
		bw.write("11111111" + "," + "00001"); 
		bw.write("\r\n");		
		bw.write("11111112" + "," + "00002"); 
		bw.write("\r\n");		
		bw.write("11111113" + "," + "00003"); 
		bw.write("\r\n");		
		bw.write("11111114" + "," + "00004"); 
		bw.write("\r\n");		
		bw.write("11111115" + "," + "00005"); 
		bw.write("\r\n");		
		bw.write("11111116" + "," + "00006"); 
		bw.close(); 
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