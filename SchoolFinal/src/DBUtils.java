import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
	private static String databaseUrl = "jdbc:mysql://localhost/school_db";
	private static String userName = "root";
	private static String pass = "";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(databaseUrl, userName, pass);
	}
}
