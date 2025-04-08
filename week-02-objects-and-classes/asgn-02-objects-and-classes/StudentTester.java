
/**
 * StudentTester class: meant to test the functionality of the Student class
 */
public class StudentTester {

    public static void main(String args[]) {
        // Creating student 1
        Student s1 = new Student("Jedi Temple 500 Republica Avenue, Coruscant", "Anakin Skywalker");

        // testing getName
        System.out.println(s1.getName());

        // testing getAddress
        System.out.println(s1.getAddress());

        // testing addCourse
        s1.addCourse(10.0, 3);
        s1.addCourse(8.7, 3);
        s1.addCourse(8.9, 3);
        s1.addCourse(9.2, 3);
        s1.addCourse(8.8, 3);
        s1.addCourse(7.3, 3);

        // testing calculateGPA
        System.out.println(s1.calculateGPA());

        // testing getStudentNum
        System.out.println(s1.getStudentNum());

        // testing getLoginId
        System.out.println(s1.getLoginId());

        // testing Student Number changes from student to student
        Student s2 = new Student("1439 E 33th, Mustafar", "Darth Vader");
        System.out.println(s2.getStudentNum());
        System.out.println(s2.getLoginId());
        Student s3 = new Student("Somewhere near Mos Eisley, Tatooine", "Ben Kenobi");
        System.out.println(s3.getStudentNum());
        System.out.println(s3.getLoginId());

    }
}
