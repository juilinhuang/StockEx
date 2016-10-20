package ie.StockEx.DatabaseConnection;

import java.io.IOException;

public interface DepotDAO {

	public abstract DepotDAOImpl selectDepotByDID(String id) throws IOException;
	
}
