
public class Main 
{

	public static void main(String[] args) 
	{
		Student student1 = new Student("Εγώ","εσύ","12","Άνδρας","κάπου 5");
		Course course = new Course("κάποιο μάθημα");
		
		Grade grade = new Grade(student1,course,10);
		
		System.out.println(student1.getOnoma());
	}

}
