import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Grade 
{
	private Student student;
	private Course course;
	private float grade;
	
	public Grade(Student student, Course course, float grade) 
	{
		this.student=student;
		this.course=course;
		this.grade=grade;
	}

	public Student getStudent() 
	{
		return student;
	}

	public void setStudent(Student student) 
	{
		this.student = student;
	}

	public Course getCourse() 
	{
		return course;
	}

	public void setCourse(Course course) 
	{
		this.course = course;
	}

	public float getGrade() 
	{
		return grade;
	}

	public void setGrade(float grade) 
	{
		this.grade = grade;
	}
	
	public int selectStudent() 
	{	
		String apotelesma = "";
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery("SELECT * FROM `students` WHERE `fname`='"+this.student.getOnoma()+"' AND `lname`='"+this.student.getEponimo()+"'");	
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
	
	public int selectCourse() 
	{
		String apotelesma = "";
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery("SELECT * FROM `courses` WHERE `title`='"+this.course.getTitle()+"'");	
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
		
		int courseId=Integer.parseInt(apotelesma);
		
		return courseId;
	}
	
	public void insertGrade() 
	{
		
		try 
		{
			Connection connection = DBUtils.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "INSERT INTO `grades`(`student_id`, `course_id`, `grade`) VALUES ('"+this.selectStudent()+"','"+this.selectCourse()+"','"+this.getGrade()+"')";
			System.out.println(sql);
			statement.execute(sql);
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	

}
