package radnom;

public class Student {
	private String lastName;
	private String firstName;
    private int midterm1;
    private int midterm2;
    private int finalScore;
    private String grade;
    
    
    public String getGrade() {
    	return grade;
    }
    public void setGrade(String gradeToSet) {
    	this.grade = gradeToSet;
    }
    public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getMidterm1() {
		return midterm1;
	}
	public void setMidterm1(int midterm1) {
		this.midterm1 = midterm1;
	}
	public int getMidterm2() {
		return midterm2;
	}
	public void setMidterm2(int midterm2) {
		this.midterm2 = midterm2;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	public void calcGradeAndSetGrade() {
		int totalScore = this.midterm1 + this.midterm2 + this.finalScore;
		int avgScore = totalScore / 3;
		this.setGrade(findGrade(avgScore));
		
	}
	
	public static String findGrade(int avgScore) {
		String grade = "";
		switch(avgScore / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
			grade = "F";
			break;
		default:
			grade = "Error in grade calculation";
			break;
		}
		
		return grade;
	}
	public Student(String last) { //constructor
		setLastName(last);
		midterm1 = 0;
		midterm2 = 0;
		finalScore = 0;
	}
	
	
    
}
