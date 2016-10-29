package ie.StockEx.StockExchangeConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class XetraConnector extends StockExchangeConnector implements Runnable {

	private int SID;
	private double currentValue;
	private String Sname;
	ArrayList<XetraConnector> list = new ArrayList<XetraConnector>();
	HashMap<Integer, XetraConnector> stock=new HashMap<Integer, XetraConnector>();
    private static final XetraConnector instance = new XetraConnector();  
    protected Map<String, Object> obs = new HashMap<String, Object>();  
    

	public double getCurrentPriceForStock(int stockId) {
		double current = stock.get(stockId).currentValue;
		// TODO Auto-generated method stub
		return current;
	}
	public synchronized void updatevalue() {
		XetraConnector ha0 = new XetraConnector();
		ha0.SID = 600012;
		ha0.currentValue = 22.34;
		ha0.Sname = "Youtube";
		list.add(ha0);
		
		XetraConnector ha1 = new XetraConnector();
		ha1.SID = 600034;
		ha1.currentValue = 32.34;
		ha1.Sname = "Google";
		list.add(ha1);
		
		XetraConnector ha2 = new XetraConnector();
		ha2.SID = 600056;
		ha2.currentValue = 12.34;
		ha2.Sname = "Line";
		list.add(ha2);
		
		XetraConnector ha3 = new XetraConnector();
		ha3.SID = 600078;
		ha3.currentValue = 42.34;
		ha3.Sname = "Skype";
		list.add(ha3);
		
		XetraConnector ha4 = new XetraConnector();
		ha4.SID = 600090;
		ha4.currentValue = 52.34;
		ha4.Sname = "Facebook";
		list.add(ha4);
		
		//¸³Öµ			
			stock.put(ha0.SID, ha0);
			stock.put(ha1.SID, ha1);
			stock.put(ha2.SID, ha2);
			stock.put(ha3.SID, ha3);
			stock.put(ha4.SID, ha4);
		final long timeInterval = 5000;// 5 seconds
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					// ------- code for task to run
					for(int i1=0;i1<stock.size();i1++)
					{
						int sid = list.get(i1).SID;
						double value = Math.random()*100 + Math.random();
						stock.get(sid).currentValue = value;
						stock.put(sid,stock.get(sid));
						//System.out.print(sid+" ");
						//System.out.println(stock.get(sid).currentValue);
					}
					// ------- ends here
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	
}
