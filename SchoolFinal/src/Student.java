import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Student 
{
	private String onoma;
	private String eponimo;
	private String birthDate;
	private String gender;
	private String address;
	
	public Student(String onoma,String eponimo, String birthDate, String gender, String address)
	{
		this.onoma=onoma;
		this.eponimo=eponimo;
		this.birthDate=birthDate;
		this.gender=gender;
		this.address=address;
	}
	
	public Student(String onoma, String eponimo) 
	{
		this.onoma = onoma;
		this.eponimo = eponimo;
	}

	public String getOnoma() {
		return onoma;
	}

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}

	public String getEponimo() {
		return eponimo;
	}

	public void setEponimo(String eponimo) {
		this.eponimo = eponimo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void saveStudent() 
	{
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "INSERT INTO students (`fname`, `lname`, `dateOfBirth`, `gender`, `adress`) VALUES ('"+this.onoma+"','"+this.eponimo+"','"+this.birthDate+"','"+this.gender+"','"+this.address+"')";
			System.out.println(sql);
			statement.execute(sql);
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public int selectStudent() 
	{	
		String apotelesma = "";
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery("SELECT * FROM `students` WHERE `fname`='"+this.getOnoma()+"' AND `lname`='"+this.getEponimo()+"'");	
			result.first();
			
			
			do
			{		
				apotelesma = result.getString("id");
				//System.out.println(result.getString("id"));
			}
			while(result.next());
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		int studentId=Integer.parseInt(apotelesma);
		
		return studentId;
					
	}
	
	public HashMap searchStudentGrades() 
	{
		//thelo ena array pou na apothikeuo ta apotelesmata toy search moy kai na to kanei return 
		
		HashMap<String, String> titleGrade = new HashMap<String, String>();
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery("SELECT courses.title, grades.grade FROM grades INNER JOIN courses ON grades.course_id = courses.id WHERE grades.student_id = '"+this.selectStudent()+"'");	
			result.first();
			
			
			do
			{	
				titleGrade.put(result.getString("title"), result.getString("grade"));
			}
			while(result.next());
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return titleGrade;
	}
}
