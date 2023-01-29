import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course 
{
	private String title;
	
	public Course(String title) 
	{
		this.title=title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void save() 
	{
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "INSERT INTO courses (title) VALUES ('"+this.title+"')";
			System.out.println(sql);
			statement.execute(sql);
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
}
