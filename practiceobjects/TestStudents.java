package practiceobjects;

public class TestStudents {

	public static void main(String[] args) {

		Student s1 = new Student("Joe", 16, 11, 'm');

		System.out.println("Name: " + s1.getName());

		s1.setAge(18);
		System.out.println("Age: " + s1.getAge());

		s1.setGrade(12);
		int joeGrade = s1.getGrade();
		System.out.println("Grade: " + joeGrade);

		s1.setMarks(70, 85, 92, 68);
		double joeAverage = s1.calcAverage();
		System.out.println(s1.getName() + "'s average: " + joeAverage + "%");

	} // end main

} // end class TestStudents
