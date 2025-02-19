
import java.util.ArrayList;

/**
 * College class: represents a college with a name and a list of students
 */
public class College {

    private String name;
    private ArrayList<Student> students;

    /**
     * College class constructor
     *
     * @param name - college's name
     */
    public College(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    /**
     * Adds a normal student to the students list
     *
     * @param address - student's address
     * @param name - student's name
     */
    public void addStudent(String address, String name) {
        students.add(new Student(address, name));
        System.out.println("Student added successfully.");
    }

    /**
     * Adds a graduate student to the students list
     *
     * @param address - student's address
     * @param name - student's name
     * @param researchTopic - student's research topic
     * @param supervisor - student's supervisor
     */
    public void addGraduateStudent(String address, String name, String researchTopic, String supervisor) {
        students.add(new GraduateStudent(address, name, researchTopic, supervisor));
        System.out.println("Graduate Student added successfully.");
    }

    /**
     * Adds an international student to the students list
     *
     * @param address - student's address
     * @param name - student's name
     * @param country - student's country of origin
     */
    public void addInternationalStudent(String address, String name, String country) {
        students.add(new InternationalStudent(address, name, country));
        System.out.println("International Student added successfully.");
    }

    /**
     * Finds a student in the students list based on the student number
     *
     * @param studentNum - student's number
     * @return
     */
    public Student findStudent(int studentNum) {
        for (Student s : students) {
            if (s.getStudentNum() == studentNum) {
                return s;
            }
        }
        return null;
    }

    /**
     * Adds a course to a student from the students list
     * 
     * @param studentNum - student's number
     * @param gradePts - student's grade points
     * @param credits - student's credits
     */
    public void addCourseToStudent(int studentNum, double gradePts, int credits) {
        Student student = findStudent(studentNum);
        if (student != null) {
            student.addCourse(gradePts, credits);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Displays the tuition of one of the students from the students list
     * 
     * @param studentNum - student's number
     */
    public void getTuitionFee(int studentNum) {
        Student s = findStudent(studentNum);
        if (s != null) {
            System.out.println("Tuition Fee: $" + s.getTuitionFees());
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Displays the students in the students list
     */
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
