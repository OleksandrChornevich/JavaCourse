package chornevich.javaweb.task1.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	public static Connection getConnection(String dBUrl, String dBUser, String dBPassword) throws SQLException, ClassNotFoundException{
		
		Connection connection = DriverManager.getConnection(dBUrl, dBUser, dBPassword);
		Class.forName("org.postgresql.Driver");
		return connection;					
}

}
