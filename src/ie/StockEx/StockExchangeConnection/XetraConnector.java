package ie.StockEx.StockExchangeConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class XetraConnector extends StockExchangeConnector {

	private int SID;
	private double currentValue;
	final long timeInterval = 5000;// 5 seconds

	ArrayList<XetraConnector> list = new ArrayList<XetraConnector>();
	HashMap<Integer, Double> stock = new HashMap<Integer, Double>();

	public XetraConnector() {
//		XetraConnector ha0 = new XetraConnector();
//		ha0.SID = 600012;
//		ha0.currentValue = 22.34;
//		list.add(ha0);
//
//		XetraConnector ha1 = new XetraConnector();
//		ha1.SID = 600034;
//		ha1.currentValue = 32.34;
//		list.add(ha1);
//
//		XetraConnector ha2 = new XetraConnector();
//		ha2.SID = 600056;
//		ha2.currentValue = 12.34;
//		list.add(ha2);
//
//		XetraConnector ha3 = new XetraConnector();
//		ha3.SID = 600078;
//		ha3.currentValue = 42.34;
//		list.add(ha3);
//
//		XetraConnector ha4 = new XetraConnector();
//		ha4.SID = 600090;
//		ha4.currentValue = 52.34;
//		list.add(ha4);

		stock.put(600012, 22.34);
		stock.put(600034, 32.34);
		stock.put(600056, 12.34);
		stock.put(600078, 42.34);
		stock.put(600090, 52.34);
	}

	public double getCurrentPriceForStock(int stockId) {
		double current = stock.get(stockId);
		// TODO Auto-generated method stub
		return current;
	}

	@Override
	public void run() {
		while (true) {
			// ------- code for task to run
			for (int i1 = 0; i1 < stock.size(); i1++) {
				int sid = list.get(i1).SID;
				double value = Math.random() * 100 + Math.random();
				stock.put(sid, value);
				notifyObservers();
			}
			// ------- ends here
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
