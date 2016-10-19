package ie.StockEx.DatabaseConnection;

//import java.util.ArrayList;

public interface TraderDAO {


	public abstract boolean login(String id,String password);
	
	public abstract String selectTnamebyTID(String TID);
	
}
