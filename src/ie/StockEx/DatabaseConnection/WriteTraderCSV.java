
package ie.StockEx.DatabaseConnection;

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 

public class WriteTraderCSV {
	public static void main(String[] args) throws IOException 
	{
		try { 
			File csv = new File("C:/Users/Administrator/Desktop/Trader.csv"); 
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
			bw.newLine(); 
			bw.write("TID" + "," + "TNAME" + "," + "TPASSWORD"); 
			bw.write("\r\n");
			bw.write("11111111" + "," + "Alice" + "," + "qwerrewq"); 
			bw.write("\r\n");		
			bw.write("11111112" + "," + "Bob" + "," + "yuiooiuy"); 
			bw.write("\r\n");		
			bw.write("11111113" + "," + "Carla" + "," + "asdffff"); 
			bw.write("\r\n");		
			bw.write("11111114" + "," + "David" + "," + "jkllll"); 
			bw.write("\r\n");		
			bw.write("11111115" + "," + "Frank" + "," + "assddee"); 
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
