package ie.StockEx.DatabaseConnection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDepotCSV {
	public static void main(String[] args) throws IOException 
	{
	try { 
		File csv = new File("C:/Users/Administrator/Desktop/Depot.csv"); 
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
		bw.newLine(); 
		bw.write("DID" + "," + "BALANCE" + "," + "OPEN DATE"); 
		bw.write("\r\n");
		bw.write("00001" + "," + "2965.78" + "," + "06AUG2012"); 
		bw.write("\r\n");		
		bw.write("00002" + "," + "3456.33" + "," + "03APR2013"); 
		bw.write("\r\n");		
		bw.write("00003" + "," + "4125.00" + "," + "22OCT2014"); 
		bw.write("\r\n");		
		bw.write("00004" + "," + "5344.99" + "," + "23FEB2015"); 
		bw.write("\r\n");		
		bw.write("00005" + "," + "200000.00" + "," + "14JUN2016"); 
		bw.write("\r\n");		
		bw.write("11111116" + "," + "Gavin" + "," + "juuiioo098"); 
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