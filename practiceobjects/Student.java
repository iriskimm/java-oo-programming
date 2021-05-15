package practiceobjects;

public class Student {

	private String name;
	private int age;
	private char gender;
	private int grade;
	private int mark1;
	private int mark2;
	private int mark3;
	private int mark4;
	private double average;

	public Student(String stName, int stAge, int stGrade, char gen) {
		this.setName(stName);
		this.setAge(stAge);
		this.setGrade(stGrade);
		this.gender = 'm';

	}

	// method getName
	// able to access or get the information
	public String getName() {

		return this.name;
	}

	// method setName
	// able to change or modify the information
	public void setName(String name) {

		this.name = name;
	}

	// method getAge
	public int getAge() {
		return this.age;
	}

	// method setAge
	public void setAge(int age) {
		this.age = age;
	}

	// method getGrade
	public int getGrade() {
		return this.grade;
	}

	// method setGrade
	public void setGrade(int grade) {
		this.grade = grade;
	}

	// method setMarks
	public void setMarks(int mark1, int mark2, int mark3, int mark4) {
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;

	}

	// method calcAverage
	public double calcAverage() {
		double avg = ((this.mark1 + this.mark2 + this.mark3 + this.mark4) / 4);
		return avg;
	}

} // end class Student
